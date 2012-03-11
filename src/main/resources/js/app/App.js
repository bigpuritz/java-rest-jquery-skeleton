var App = {

    initialize:function () {
        var self = this;

        $("#modal").ajaxError(function (e, jqxhr, settings, exception) {
            $(this).find(".modal-header h3").html("Server communication error!");
            $(this).find(".modal-body p").html("Error requesting resource: <strong>" + settings.url + "</strong>");
            $(this).modal();
        });

        $("#morePins").click(function (event) {
            event.preventDefault();
            self.loadPins();
        });

        self.loadPins();
    },

    loadPins:function () {
        var self = this;
        $("#morePins").button('loading');
        $.getJSON('rest/pin', function (data) {
            $.each(data, function (key, val) {
                var pin = $(Templates.pin(val));
                pin.children(".close").click(function (event) {
                    event.preventDefault();
                    $(pin).remove();
                });
                pin.find("div.comments button").click(function (event) {
                    event.preventDefault();
                    self.loadComments(pin.children("div.comments"));
                });
                $("#app").append(pin);
            });
            $("#morePins").button('reset');
        });
    },


    loadComments:function (container) {
        var btn = container.find("button");
        btn.button('loading');
        $.getJSON('rest/comment', function (data) {
            $.each(data, function (key, val) {
                var comment = $(Templates.comment(val));
                container.append(comment);
            });
            btn.button('reset');
        });
    }


};