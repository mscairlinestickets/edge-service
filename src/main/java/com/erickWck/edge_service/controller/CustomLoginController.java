package com.erickWck.edge_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Usamos RestController para retornar diretamente o conteúdo
public class CustomLoginController {


    @GetMapping(value = "/login", produces = "text/html")
    public String customLoginPage() {
        // Os links são fixos, baseados no seu "registrationId" configurado no application.yml:
        // Ex: google e github

        return """
            <!DOCTYPE html>
            <html lang="pt">
            <head>
                <meta charset="UTF-8">
                <title>Login Customizado</title>
                <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
                <style>
                    .container {
                        max-width: 400px;
                        margin-top: 100px;
                        padding: 30px;
                        box-shadow: 0 0 10px rgba(0,0,0,.1);
                        border-radius: 8px;
                    }
                    .btn-social {
                        margin-bottom: 10px;
                        width: 100%;
                    }
                </style>
            </head>
            <body>
                <div class="container">
                    <h2 class="text-center mb-4">Acessar com OAuth 2.0</h2>
                    
                    <a href="/oauth2/authorization/google" class="btn btn-lg btn-block btn-primary btn-social">
                        Continuar com Google
                    </a>
                    
                    <a href="/oauth2/authorization/github" class="btn btn-lg btn-block btn-dark btn-social">
                        Continuar com Github
                    </a>
                    
                    <p class="mt-3 text-center text-muted">Use suas contas sociais para acessar.</p>
                </div>
            </body>
            </html>
            """;
    }
}