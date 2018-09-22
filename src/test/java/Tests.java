import Controllers.PetController;
import Enums.StatusEnum;
import Models.PetModel;
import Models.PetNotFoundModel;
import Models.Tag;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Tests {
    @Test
    public void SimpleTestAddPet() {
        PetModel testPet = new PetModel(new ArrayList<String>(), "Hartung like cats", 666, null, new ArrayList<Tag>(), StatusEnum.AVAILABLE.name());
        PetController petController = new PetController(testPet);

        PetModel petAddResponse = petController.addNewPet();

        assertTrue(petAddResponse.equals(testPet));
    }

    @Test
    public void SimpleTestUpdatePet() {
        String updateName = RandomStringUtils.randomAlphabetic(10);
        PetModel testPet = new PetModel(new ArrayList<String>(), "Hartung like dogs", 12, null, new ArrayList<Tag>(), StatusEnum.UNAVAILABLE.name());
        PetController petController = new PetController(testPet);
        PetModel petAddResponse = petController.addNewPet();
        assertTrue(petAddResponse.equals(testPet));


        testPet.setName(updateName);
        testPet.setStatus(StatusEnum.AVAILABLE.name());

        PetModel petUpdateResponse = petController.updatePet();

        assertEquals(petUpdateResponse, testPet);


    }


    @Test
    public void SimpleTestDeletePet() {
        PetModel testPet = new PetModel(new ArrayList<String>(), "3424", 555, null, new ArrayList<Tag>(), StatusEnum.AVAILABLE.name());

        PetController petController = new PetController(testPet);
        PetModel petAddResponse = petController.addNewPet();

        assertTrue(petAddResponse.equals(testPet));

        petController.deletePet();

        PetNotFoundModel petNotFoundModel = (PetNotFoundModel) petController.getPet();

        assertEquals(petNotFoundModel.getMessage(), ("Pet not found"));


    }

}

