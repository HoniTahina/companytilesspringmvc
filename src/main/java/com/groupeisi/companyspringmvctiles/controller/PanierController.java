package com.groupeisi.companyspringmvctiles.controller;

import com.groupeisi.companyspringmvctiles.dto.ClientDto;
import com.groupeisi.companyspringmvctiles.dto.PanierDto;
import com.groupeisi.companyspringmvctiles.dto.ProductDto;
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
public class PanierController {
    private static final Logger logger = LoggerFactory.getLogger(PanierController.class);

    private IPanierService panierService;
    private final IProductService productService = new ProductService();
    private final IClientService clientService = new ClientService();
    public PanierController(){
        this.panierService = new PanierService();
    }

    @GetMapping("/products")
    public String showPaniers(Model model) {
        logger.info("PanierController - Méthode GET appelée pour afficher les produits");

        try {
            Optional<List<PanierDto>> paniers = panierService.findAll();
            if (paniers.isPresent()) {
                logger.info("PanierController - Liste des paniers récupérée avec succès");
                model.addAttribute("panierList", paniers.get());
            } else {
                logger.info("PanierController - Aucun panier trouvé");
                model.addAttribute("panierList", new ArrayList<PanierDto>());
            }
        } catch (Exception e) {
            logger.error("PanierController - Erreur lors de la récupération des paniers", e);
        }

        return "paniers";
    }

    @PostMapping("/paniers")
    public String savePanier(
            @RequestParam("date") Date date,
            @RequestParam("clientTel") String clientTel,
            @RequestParam("productRef") String productRef) {

        logger.info("PanierController - Méthode POST appelée pour enregistrer un paniers");
        logger.debug("PanierController - Paramètres reçus : date={}, clientTel={}, productRef={}", date, clientTel, productRef);

        Optional<ProductDto> productOptional = productService.findByRef(productRef);
        Optional<ClientDto> clientOptional = clientService.findByTel(clientTel);
        if (productOptional.isPresent()) {
            List<ProductDto> productDto = productOptional.get();
            if (clientOptional.isPresent()) {
                ClientDto clientDto = clientOptional.get();

                PanierDto panierDto = new PanierDto();
                panierDto.setDate(date);
                panierDto.setClient(clientDto);
                panierDto.setProducts(productDto);

                try {
                    panierService.save(panierDto);
                    logger.info("Panier enregistré avec succès");
                } catch (Exception e) {
                    logger.error("Erreur lors de l'enregistrement du panier", e);
                }
            }else {
                logger.error("Client non trouvé avec la référence ");
            }
        } else {
            logger.error("Produits non trouvé avec la référence ");
        }

        return "redirect:/paniers";
    }
}
