package rest.solution;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceImpl implements ModelService {
@Autowired
    dbFunc modelRepository;
    @Override
    public Model getById(Long id) {
    //   log.info("IN CustomerServiceImpl getById {}", id);
    return null;
    }



    @Override
    public void Save(Model model) {
        System.out.println("Save user: " + model);
        modelRepository.save(model);
    }

    @Override
    public void Delete(Long id) {
        System.out.println("Delete user: " + id);
        modelRepository.deleteById(id);
    }

    @Override
    public List<Model> getAll() {
        System.out.println("Get All User: ");
        return modelRepository.findAll();
    }
}
