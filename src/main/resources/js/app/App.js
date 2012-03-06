var App = {

    initialize: function() {
        var self = this;
        $("#morePins").click(function(event){
            event.preventDefault();
            self.loadPins();
        });

        self.loadPins();
    },

    loadPins: function() {
       var self = this;
       $.getJSON('rest/pin', function(data) {
           $.each(data, function(key, val) {
               var pin = $(Templates.pin(val));
               pin.children(".close").click(function(event){
                    event.preventDefault();
                    $(pin).remove();
               });
               pin.find("div.comments a").click(function(event){
                    event.preventDefault();
                    self.loadComments(pin.children("div.comments"));
               });
               $("#app").append(pin);
           });
       });
    },


    loadComments: function(container){
        $.getJSON('rest/comment', function(data) {
           $.each(data, function(key, val) {
               var comment = $(Templates.comment(val));
               container.append(comment);
           });
        });
    }


};