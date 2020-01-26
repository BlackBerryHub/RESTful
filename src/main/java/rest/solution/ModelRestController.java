package rest.solution;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.net.ssl.HttpsURLConnection;
import javax.validation.Valid;
import javax.validation.constraints.Null;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ModelRestController
{
    private final ModelService modelService;

    public ModelRestController(ModelService modelService) {
        this.modelService = modelService;
    }

    @RequestMapping(value = "{id}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Model> getModel(@PathVariable("id") Long modelId)
    {
        if(modelId == null)
        {
            return new ResponseEntity<Model>(HttpStatus.BAD_REQUEST);
        }
        Model model = this.modelService.getById(modelId);
        if(model == null)
        {
            return new ResponseEntity<Model>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(model, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Model> saveModel(@RequestBody @Valid Model model)
    {
        HttpHeaders headers = new HttpHeaders();
        if(model == null)
        {
            return new ResponseEntity<Model>(HttpStatus.BAD_REQUEST);
        }
        this.modelService.Save(model);
        return new ResponseEntity<Model>(model, headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Model> updateModel(@RequestBody @Valid Model model)
    {
        HttpHeaders headers = new HttpHeaders();
        if(model == null)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.modelService.Save(model);
        return new ResponseEntity<>(model, headers, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Model> deleteModel(@PathVariable("id") Long id)
    {
        Model model = this.modelService.getById(id);
        if (model == null)
        {
            return new ResponseEntity<Model>(HttpStatus.NOT_FOUND);
        }
        this.modelService.Delete(id);
        return new ResponseEntity<Model>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Model>> getAllModel()
    {
        List<Model> model = this.modelService.getAll();
        if(model.isEmpty())
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(model, HttpStatus.OK);
    }
}
