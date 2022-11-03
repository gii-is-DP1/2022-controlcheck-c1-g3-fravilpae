package org.springframework.samples.petclinic.recoveryroom;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RecoveryRoomController {
    
    RecoveryRoomService service;
    private static final String VIEWS_RECOVERY_ROOMS_CREATE_OR_UPDATE_FORM = "recoveryroom/createOrUpdateRecoveryRoomForm";

    @Autowired
    public RecoveryRoomController(RecoveryRoomService service) {
        this.service=service;
    }

    @GetMapping(value = "/recoveryroom/create")
	public String initCreationForm(ModelMap model) {
		RecoveryRoom recoveryRoom = new RecoveryRoom();
		model.put("recoveryRoom", recoveryRoom);
		return VIEWS_RECOVERY_ROOMS_CREATE_OR_UPDATE_FORM;
	}

     
    @PostMapping(value ="/recoveryroom/create")
    public String processCreationForm(@Valid RecoveryRoom recoveryRoom, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            model.put("recoveryRoom", recoveryRoom);
            return VIEWS_RECOVERY_ROOMS_CREATE_OR_UPDATE_FORM;
        }
        else {
            this.service.save(recoveryRoom);
            return "welcome";
        }
    }
    
}
