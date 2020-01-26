package rest.solution;

import java.util.List;

public interface ModelService {
    Model getById(Long id);
    void Save(Model model);
    void Delete(Long id);

    List<Model> getAll();
}
