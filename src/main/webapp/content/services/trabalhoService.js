/*global mostra_app*/


mostra_app.factory('TrabalhoService', ['$resource', function trabalhoService ($resource) {
        
        var Trabalho = $resource(window.base_url + '/webresources/trabalho/:action/:termo', {action: '@action', termo: '@termo'});
        
        return {
            getAreas : function (success, error) {
                Trabalho.query({action: 'areas'}, success, error);
            },
            getCategorias: function (success, error) {
                Trabalho.query({action: 'categorias'}, success, error);
            },
            getModalidades: function (success, error) {
                Trabalho.query({action: 'modalidades'}, success, error);
            },           
            buscarAutor: function (termo, success, error) {
                Trabalho.query({action: 'buscar_autor', termo: termo}, success, error);
            },
            buscarOrientador: function (termo, success, error) {
                Trabalho.query({action: 'buscar_orientador', termo: termo}, success, error);
            },
            enviarTrabalho: function (trabalho, success, error) {
                Trabalho.save({action: 'salvar'}, trabalho, success, error);
            },
            getTrabalho: function (id, success, error) {
                Trabalho.get({action: id}, success, error);
            }
        };
}] ); 


