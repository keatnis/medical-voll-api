package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    @PostMapping

    //agregamos la anotacion @Valid para validar las entradas
    public void registrarMedico(@RequestBody @Valid DatosRegistroMedico datosRegistroMedico) {
        medicoRepository.save(new Medico(datosRegistroMedico));
    }

    @GetMapping
    public Page<DatosListadoMedico> listadoMedicos(@PageableDefault(size = 2, sort = {"nombre"}) Pageable pageable) {
        //esto permite traer solo los datos especificados en el dto
        //  return medicoRepository.findAll().stream().map(DatosListadoMedico::new).toList();
   //     return medicoRepository.findAll(pageable).map(DatosListadoMedico::new);
        return medicoRepository.findByActivoTrue(pageable).map(DatosListadoMedico::new);

    }

    //metodo para actualizar datos, usamos la anotacion Transactonal para actualizar los datos
    /* body  {"id": 6,
			"nombre": "Lupe A. Mateos"
		}
     */
    @PutMapping
    @Transactional
    public void actualizarMedico(@RequestBody @Valid DatosActualizarMedico datosActualizarMedico) {
        Medico medico = medicoRepository.getReferenceById(datosActualizarMedico.id());
        medico.actualizarDatos(datosActualizarMedico);
    }
    // metodo para elimnar los datos en la base de datos
    /*
        @DeleteMapping("/{id}")
    @Transactional
    public void eliminarMedico(@PathVariable Long id){
        Medico medico = medicoRepository.getReferenceById(id);
        medicoRepository.delete(medico);
    }
     */

    //DETELE LOGICO: no eliminamos los datos en la base de datos
    @DeleteMapping("/{id}")
    @Transactional
    public void eliminarMedico(@PathVariable Long id){
        Medico medico = medicoRepository.getReferenceById(id);
      // medico.desactivarMedico(medico);
        medico.desactivarMedico();
    }
    /*
        Exclusion de medicos
        Reglas del negocio:
        - registro no debe de ser borrado en la base de datos, para llevar un historial
        - listado debe de retornar solo medicos activos.

        usamos path variable desde url enviado por el cliente
        http://localhost:8080/medicos/6
     */


}
