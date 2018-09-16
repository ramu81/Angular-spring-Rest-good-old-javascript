(function(app){
	app.BooksSortPipe = ng.core
	.Pipe({
		name: 'sort'
	})
	.Class({
		constructor: function() {},
		transform: function(books) {
			let byName = function(book1,book2){
				return book1.name.localeCompare(book2.name);
			}
			return books.slice().sort(byName);
		}
	});
})( window.app || ( window.app = {} ) );