package com.groupeisi.companyspringmvctiles.controller;

import com.groupeisi.companyspringmvctiles.dto.ClientDto;
import com.groupeisi.companyspringmvctiles.dto.ProductDto;
import com.groupeisi.companyspringmvctiles.service.ClientService;
import com.groupeisi.companyspringmvctiles.service.IClientService;
import com.groupeisi.companyspringmvctiles.service.IProductService;
import com.groupeisi.companyspringmvctiles.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class ClientController {
    private static final Logger logger = LoggerFactory.getLogger(ClientController.class);

    private IClientService clientService;

    public ClientController(){
        this.clientService = new ClientService();
    }

    @GetMapping("/clients")
    public String showClients(Model model) {
        logger.info("ClientController - Méthode GET appelée pour afficher les clients");

        try {
            Optional<List<ClientDto>> clients = clientService.findAll();
            if (clients.isPresent()) {
                logger.info("ClientController - Liste des clients récupérée avec succès");
                model.addAttribute("clientList", clients.get());
            } else {
                logger.info("ClientController - Aucun client trouvé");
                model.addAttribute("clientList", new ArrayList<ClientDto>());
            }
        } catch (Exception e) {
            logger.error("ClientController - Erreur lors de la récupération des clients", e);
        }

        return "clients";
    }

    @PostMapping("/clients")
    public String saveClient(
            @RequestParam("firstname") String firstname,
            @RequestParam("lastname") String lastname,
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            @RequestParam("tel") String tel,
            @RequestParam("address") String address) {

        logger.info("ClientController - Méthode POST appelée pour enregistrer un client");
        logger.debug("ClientController - Paramètres reçus : firstname={}, lastname={}, email={}, password={}, tel={}, address={}", firstname, lastname, email, password, tel, address);

        ClientDto clientDto = new ClientDto();
        clientDto.setFirstname(firstname);
        clientDto.setLastname(lastname);
        clientDto.setEmail(email);
        clientDto.setPassword(password);
        clientDto.setTel(tel);
        clientDto.setAddress(address);

        try {
            boolean clientSaved = clientService.save(clientDto);

            if (clientSaved) {
                logger.info("ClientController - client enregistré avec succès");
            } else {
                logger.warn("ClientController - Échec de l'enregistrement du client");
            }
        } catch (Exception e) {
            logger.error("ClientController - Erreur lors de l'enregistrement du client", e);
        }

        return "redirect:/clients";
    }


}
