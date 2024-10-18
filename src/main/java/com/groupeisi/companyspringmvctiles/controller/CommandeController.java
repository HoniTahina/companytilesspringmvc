package com.groupeisi.companyspringmvctiles.controller;

import com.groupeisi.companyspringmvctiles.dto.CommandeDto;
import com.groupeisi.companyspringmvctiles.dto.PanierDto;
import com.groupeisi.companyspringmvctiles.dto.ProductDto;
import com.groupeisi.companyspringmvctiles.dto.PurchasesDto;
import com.groupeisi.companyspringmvctiles.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class CommandeController {
    private static final Logger logger = LoggerFactory.getLogger(CommandeController.class);

    private ICommandeService commandeService;

    private final IPanierService panierService = new PanierService();
    public CommandeController(){
        this.commandeService = new CommandeService();
    }

    @GetMapping("/commandes")
    public String showCommandes(Model model) {
        logger.info("CommandeController - Méthode GET appelée pour afficher les commandes");

        try {
            Optional<List<CommandeDto>> commandes = commandeService.findAll();
            if (commandes.isPresent()) {
                logger.info("CommandeController - Liste des commandes récupérée avec succès");
                model.addAttribute("commandeList", commandes.get());
            } else {
                logger.info("CommandeController - Aucun commande trouvé");
                model.addAttribute("commandeList", new ArrayList<CommandeDto>());
            }
        } catch (Exception e) {
            logger.error("CommandeController - Erreur lors de la récupération des commandes", e);
        }

        return "commandes";
    }

    @PostMapping("/commandes")
    public String saveCommande(
            @RequestParam("Date") Date date,
            @RequestParam("panierId") long panierId) {

        logger.info("CommandeController - Méthode POST appelée pour enregistrer une commande");
        logger.debug("CommandeController - Paramètres reçus : date={}, panierId={}", date, panierId);

        Optional<PanierDto> panierOptional = panierService.findById(panierId);

        if (panierOptional.isPresent()) {
            PanierDto panierDto = panierOptional.get();

            CommandeDto commandeDto = new CommandeDto();
            commandeDto.setDate(date);
            commandeDto.setPanier(panierDto);

            try {
                commandeService.save(commandeDto);
                logger.info("Commande enregistré avec succès");
            } catch (Exception e) {
                logger.error("Erreur lors de l'enregistrement de la commande", e);
            }
        } else {
            logger.error("panier non trouvé avec la référence ");
        }

        return "redirect:/commandes";
    }


}
