angular.module('estoque').controller('EstoqueController', function($scope, $http, $routeParams) {
	
	listarEstoques();
	limparMensagens();
	
	$scope.estoque = {};
	
	$scope.filtro = '';
	
	function limparMensagens(){
		$scope.mensagem = '';
		$scope.mensagemModal = '';
	};
	
	if($routeParams.idEstoque){
		$http.get('estoque/pesquisarEstoque?idEstoque=' + $routeParams.idEstoque).then(function(estoqueSalvo) {
			$scope.estoque = estoqueSalvo.data;
		}).catch(function(error){
			console.log(error);
		});
	}
	
	$scope.editarEstoque = function(estoque) {
		$scope.estoque = estoque
		limparMensagens();
	}
	
	$scope.novoEstoque = function() {
		$scope.estoque = {};
		limparMensagens();
		$scope.cadastro.$submitted = false;
	}

	function listarEstoques(){
		$http.get('estoque/listarEstoques').then(function(estoques) {
			$scope.estoques = estoques.data;
		}).catch(function(error){
			console.log(error);
		});
	}
	
	$scope.salvarEstoque = function() {
		if($scope.cadastro.$valid){
			$http.post('estoque/salvarEstoque', $scope.estoque).then(function(estoqueSalvo) {
				$scope.estoque = estoqueSalvo.data;
				$scope.mensagemModal = 'Cadastro efetuado com sucesso';
				listarEstoques();
			}).catch(function(error){
				console.log(error);
				$scope.mensagemModal = 'Não foi possível cadastrar';
			});
		}
	};
	
	$scope.removerEstoque = function(estoque) {
		$http.delete('estoque/removerEstoque?idEstoque=' + estoque.idEstoque).then(function() {
			var indiceEstoque = $scope.estoques.indexOf(estoque);
			$scope.estoques.splice(indiceEstoque, 1);
			
			$scope.mensagem = 'Estoque ' + estoque.descricao + ' foi removido com sucesso';
		}).catch(function(error){
			console.log(error);
			$scope.mensagem = 'Não foi possível remover';
		});
	}
});