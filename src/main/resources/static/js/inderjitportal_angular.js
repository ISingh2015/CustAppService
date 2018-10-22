/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var invMain = angular.module("invMain", []);
invMain.controller("invMainController", function ($scope) {
    $scope.greeting = {id: "angular JS", content: "Test Angular Content"};
    console.log('Angular loaded');
});
