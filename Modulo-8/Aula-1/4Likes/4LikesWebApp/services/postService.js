app.service('postService', function($http) {
 
    this.getPostsFeed = function() {
        return $http.get('http://localhost:9090/posts/feed');
    }
});