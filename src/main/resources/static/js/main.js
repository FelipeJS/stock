angular.module('estoque', ['minhasDiretivas', 'ngRoute'])
.config(function($routeProvider) {
	
	$routeProvider.when('/', {
		templateUrl: 'partials/principal.html'
	});
	
	$routeProvider.when('/estoque', {
		templateUrl: 'partials/estoque.html',
		controller: 'EstoqueController'
	});
	
	$routeProvider.when('/estoque/:idEstoque', {
		templateUrl: 'partials/estoque.html',
		controller: 'EstoqueController'
	});
	
	$routeProvider.otherwise({ redirectTo: '/'});
});

