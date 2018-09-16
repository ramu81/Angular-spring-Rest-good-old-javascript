(function(app){
	app.BooksComponent = ng.core
	.Component({
		selector: 'books',
		templateUrl: 'app/books.component.html',
		providers: [app.BooksService]
	})
	.Class({
		constructor: [app.BooksService, function(service){
			this.service = service;
			this.message = ' ';
			this.books = [];
			this.newBook = {};
		}],
		getBooks: function(){			
			this.service.get()
			.subscribe(this.updateBooks.bind(this),
					this.updateMessage.bind(this));
		},
		updateBooks: function(books){
			this.books = books;
		},refreshBooks: function(message){
			this.message = message;
			this.getBooks();
		},
		updateMessage: function(error){
			this.message = error;
		},
		addANewBook: function(){
			this.service.addANewBook(this.newBook)
			.subscribe(this.refreshBooks.bind(this),
					this.updateMessage.bind(this));
		},
		deleteBook: function(isbn){
			this.service.deleteANewBook(isbn)
			.subscribe(this.refreshBooks.bind(this),
					this.updateMessage.bind(this));
		},
		ngOnInit: function(){
			this.getBooks();
		}
	});
})( window.app || ( window.app = {} ) );