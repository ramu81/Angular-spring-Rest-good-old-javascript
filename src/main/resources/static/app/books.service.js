(function(app){
	app.BooksService = ng.core
	.Class({
		constructor: [ng.http.Http, function(http) {
			this.http = http;
		}],
		get: function() {
			return this.http.get('books')
			.map(this.extractBooks)
			.catch(this.extractError);
		},
		extractBooks: function(response) {
			if(response.status === 200)
				return response.json();
			else 
				throw new Error('Error getting books');
		},
		extractResponse:  function(response) {
			if(response.status === 201 || response.status === 200)
				return response.text();
			else 
				throw new Error('Error getting books');
		},
		extractError: function(error) {
			return Rx.Observable.throw(error.message || 'error getting books');
		},
		addANewBook: function(newBook) {
			let data = JSON.stringify(newBook);
			let options = {headers: new ng.http.Headers({'Content-Type': 'application/json'})};
			return this.http.post('addBook',data,options)
			.map(this.extractResponse)
			.catch(this.extractError);
		},
		deleteANewBook: function(isbn) {
			return this.http.delete('deleteBook/'+isbn)
			.map(this.extractResponse)
			.catch(this.extractError);
		}
	});
})( window.app || ( window.app = {} ) );