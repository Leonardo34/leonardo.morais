app.controller('feedController', function($scope, authService, postService) {
    carregarPostsFeed();

    function carregarPostsFeed() {
        postService.getPostsFeed().then(res => {
            $scope.posts = res.data;
            console.log($scope.posts);
        }, error => {
            window.alert("Erro");
        })
    }
});