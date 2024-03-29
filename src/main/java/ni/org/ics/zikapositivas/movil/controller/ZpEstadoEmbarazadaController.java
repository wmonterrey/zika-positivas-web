package ni.org.ics.zikapositivas.movil.controller;

import ni.org.ics.zikapositivas.domain.ZpEstadoEmbarazada;
import ni.org.ics.zikapositivas.service.ZpEstadoEmbarazadaService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * Manejo de las solicitudes a la aplicacion mediante JSON para el formulario Zp00Screening
 * Created by FIRSTICT on 10/11/2016.
 * V1.0
 */
@Controller
@RequestMapping("/movil/*")
public class ZpEstadoEmbarazadaController {
    @Resource(name = "zpEstadoEmbarazadaService")
    private ZpEstadoEmbarazadaService zpEstadoEmbarazadaService;

    private static final Logger logger = LoggerFactory.getLogger(ZpEstadoEmbarazadaController.class);

    /**
     * Acepta una solicitud GET para JSON
     * @return JSON
     */
    @RequestMapping(value = "zpEstadoEmb", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    List<ZpEstadoEmbarazada> getZpEstadoEmbarazadas() {
        logger.info("Descargando toda la informacion de los datos de los formulario ZpEstadoEmbarazada");
        List<ZpEstadoEmbarazada> zpEstadoEmbarazada = zpEstadoEmbarazadaService.getZpEstadoEmbarazada();
        if (zpEstadoEmbarazada == null){
            logger.debug("Nulo");
        }
        return zpEstadoEmbarazada;
    }
    
    /**
     * Acepta una solicitud GET para JSON
     * @return JSON
     */
    @RequestMapping(value = "zpEstadoEmb/{username}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    List<ZpEstadoEmbarazada> getZpEstadoEmbarazadas(@PathVariable String username) {
        logger.info("Descargando toda la informacion de los datos de los formulario ZpEstadoEmbarazadapara el usuario " +username);
        List<ZpEstadoEmbarazada> zpEstadoEmbarazada = zpEstadoEmbarazadaService.getZpEstadoEmbarazadByUser(username);
        if (zpEstadoEmbarazada == null){
            logger.debug("Nulo");
        }
        return zpEstadoEmbarazada;
    }

    /**
     * Acepta una solicitud POST con un par�metro JSON
     * @param envio Objeto serializado de ZpEstadoEmbarazada
     * @return String con el resultado
     */
    @RequestMapping(value = "zpEstadoEmb", method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody String saveZpEstadoEmbarazada(@RequestBody ZpEstadoEmbarazada[] envio) {
        logger.debug("Insertando/Actualizando formularios ZpEstadoEmbarazada");
        if (envio == null){
            logger.debug("Nulo");
            return "No recibi nada!";
        }
        else{
            List<ZpEstadoEmbarazada> zpEstadoEmbarazadas = Arrays.asList(envio);
            for (ZpEstadoEmbarazada zpEstadoEmbarazada : zpEstadoEmbarazadas){
            	zpEstadoEmbarazadaService.saveZpEstadoEmbarazada(zpEstadoEmbarazada);
            }
        }
        return "Datos recibidos!";
    }
}
