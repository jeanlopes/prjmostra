/*global mostra_app*/


mostra_app.controller('TrabalhoController', ['$scope', '$location', 'TrabalhoService', function TrabalhoController($scope, $location, trabalhoService) {

        'use strict';
        $scope.id_trabalho = 0;
        $scope.caracteres_titulo = 250;
        $scope.caracteres_resumo = 3000;
        $scope.trabalho = {};
        $scope.trabalho.autores_ids = [];
        $scope.trabalho.cursos_ids = [];
        $scope.trabalho.orientadores_ids = [];
        $scope.trabalho.campus_ids = [];
        $scope.trabalho.autores = [];
        $scope.trabalho.orientadores = [];
        $scope.trabalho.palavras_chave = [];
        $scope.areas_tematicas = [];
        $scope.categorias = [];
        $scope.modalidades = [];
        $scope.autores_disponiveis = [];
        $scope.orientadores_disponiveis = [];

        $scope.$watch('trabalho.titulo', function () {
            var result = $($scope.trabalho.titulo).text();
            if (result !== '')
                $scope.trabalho.titulo = result;
        });

        $scope.$watch('trabalho.resumo', function () {
            var result = $($scope.trabalho.resumo).text();
            if (result !== '')
                $scope.trabalho.resumo = result;
        });

        trabalhoService.getAreas(function (areas) {
            $scope.areas_tematicas = areas;
        }, function (error) {
            console.log('erro recuperando áreas temáticas ' + JSON.stringify(error));
        });

        trabalhoService.getCategorias(function (categorias) {
            $scope.categorias = categorias;
        }, function (error) {
            console.log('erro recuperando categorias ' + JSON.stringify(error));
        });

        trabalhoService.getModalidades(function (modalidades) {
            $scope.modalidades = modalidades;
        }, function (error) {
            console.log('erro recuperando modalidades ' + JSON.stringify(error));
        });

        $scope.niveis = [{'idNivel': 1, 'nome': 'técnico'}, {'idNivel': 2, 'nome': 'superior'}];

        var id = $location.search().id;

        if (id) {

            trabalhoService.getTrabalho(id, function success(trabalho) {
                $scope.trabalho.id_trabalho = trabalho.idTrabalho;
                $scope.trabalho.titulo = trabalho.titulo;
                $scope.trabalho.resumo = trabalho.resumo;
                $scope.trabalho.palavras_chave.push(trabalho.palavra1);
                $scope.trabalho.palavras_chave.push(trabalho.palavra2);
                $scope.trabalho.palavras_chave.push(trabalho.palavra3);
                $scope.trabalho.autores = trabalho.listaAutores;
                $scope.trabalho.orientadores = trabalho.listaOrientadores;
                $scope.trabalho.categoria = {'idCategoria': trabalho.categoria.idCategoria, 'nome': trabalho.categoria.nome};
                $scope.trabalho.area_tematica = {'idArea': trabalho.area.idArea, 'nome': trabalho.area.nome};
                $scope.trabalho.modalidade = {'idModalidade': trabalho.modalidade.idModalidade, 'nome': trabalho.modalidade.nome};
                $scope.trabalho.nivel = {'idNivel': trabalho.nivel.idNivel, 'nome': trabalho.nivel.nome };

            }, function error(error) {
                console.log('erro recuperando o trabalho' + JSON.stringify(error));
            });
        }

        $scope.buscarAutor = function (tokens) {
            $scope.autores_disponiveis = [];
            if (tokens.length > 2) {
                trabalhoService.buscarAutor(tokens, function (coautores) {
                    if (coautores) {
                        coautores.forEach(function (coautor) {
                            $scope.autores_disponiveis.push(coautor);
                        });
                    }
                }, function (message) {
                    console.log('ocorreu algum erro no servidor! ' + JSON.stringify(message));
                });
            }
        };

        $scope.inserirAutor = function (autor) {

            if ($scope.trabalho.autores.length === 4) {
                alert('não é possível inserir mais de 4 autores!');
                return;
            }
            $scope.trabalho.autores.push(autor);
        };

        $scope.removerAutor = function (autor) {
            $scope.trabalho.autores.splice($scope.trabalho.autores.indexOf(autor), 1);
        };

        $scope.buscarOrientador = function (tokens) {
            $scope.orientadores_disponiveis = [];
            if (tokens.length > 2) {
                trabalhoService.buscarOrientador(tokens,
                        function success(orientadores) {
                            orientadores.forEach(function (orientador) {
                                $scope.orientadores_disponiveis.push(orientador);
                            });
                        }, function error(message) {
                    console.log('ocorreu algum erro no servidor! ' + JSON.stringify(message));
                });
            }

        };

        $scope.inserirOrientador = function (orientador) {

            if ($scope.trabalho.orientadores.length === 2) {
                alert('não é possível inserir mais orientadores!');
                return;
            }
            $scope.trabalho.orientadores.push(orientador);
        };

        $scope.removerOrientador = function (orientador) {
            $scope.trabalho.orientadores.splice($scope.trabalho.orientadores.indexOf(orientador), 1);
        };

        $scope.adicionarPalavraChave = function (palavra_chave) {

            if ($scope.trabalho.palavras_chave.length === 3) {
                alert('não é possível inserir mais palavras chave');
                return;
            }

            $scope.trabalho.palavras_chave.push(palavra_chave);
        };

        $scope.removerPalavraChave = function (palavra) {

            $scope.trabalho.palavras_chave.splice($scope.trabalho.palavras_chave.indexOf(palavra), 1);
        };

        $scope.enviarTrabalho = function () {

            $scope.trabalho.autores.forEach(function (autor) {
                $scope.trabalho.autores_ids.push(autor.idAutor);
                $scope.trabalho.cursos_ids.push(autor.idCurso);
            });

            $scope.trabalho.orientadores.forEach(function (orientador) {

                $scope.trabalho.orientadores_ids.push(orientador.idOrientador);
                $scope.trabalho.campus_ids.push(orientador.idCampus);
            });

            trabalhoService.enviarTrabalho($scope.trabalho,
                    function success() {
                        alert('trabalho submetido com sucesso!');

                    }, function error(data) {
                console.log('não foi possível enviar o trabalho ' + JSON.stringify(data));
            });
        };



    }]);
        