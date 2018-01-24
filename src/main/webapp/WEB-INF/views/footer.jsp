<footer>
    <span>&copy; 2017 - Generador</span>
    <script type="text/javascript">
        $(function () {
            var token = $("meta[name='_csrf']").attr("content");
            var header = $("meta[name='_csrf_header']").attr("content");
            $("#jqgridExport").attr('name', $("meta[name='_csrf_header']").attr("content"));
            $("#jqgridExport").val($("meta[name='_csrf']").attr("content"));
            if (token != "" && header != "") {
                $(document).ajaxSend(function (e, xhr, options) {
                    xhr.setRequestHeader(header, token);
                });
            }
        });
    </script>
</footer>


