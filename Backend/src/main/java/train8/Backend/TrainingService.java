package train8.Backend;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TrainingService {

    private TrainingCenterRepository repository;
    public TrainingCenter saveTrainingCenter(TrainingCenter trainingCenter) {
        // Set server time for 'createdOn'
        trainingCenter.setCreatedOn(Instant.now().getEpochSecond());
        return repository.save(trainingCenter);
    }

    public List<TrainingCenter> getAllTrainingCenters() {
        return repository.findAll();
    }

}
