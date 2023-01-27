# Projeto_Consenso_APP
 @GetMapping("/servico/usuario/{id}")
    public List<Servico> servicosUsuarioId(@PathVariable Integer id){
        return servicoService.findByidUsuario(id);
    }
