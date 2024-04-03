class Product {

    constructor() {
        const table = new DataTable('#table-product', {
            ajax: {
                url: '/product/list',
                dataSrc: ''
            },
            columns: [
                {data: 'name'},
                {data: 'variation'}
            ]
        });

        $("#addVariation").on("click", function () {
            $("#variationList").append('<div class="row mb-3"><div class="col"><label for="inputVariationName2" class="col-form-label">Variation Name2</label><input type="text" id="inputVariationName2" name="variationName2" class="form-control"></div></div>');
        });

        $("#saveNewProduct").on("click", function () {
            $.ajax({
                url: "/product/add",
                contentType: "application/json",
                type: "post",
                dataType: "json",
                data: convertSerializedFormToJson($("#addProduct").serialize()),
                success: function (data) {
                    // ... do something with the data...
                }
            });
        });

        function convertSerializedFormToJson(serializedForm) {
            let data = serializedForm.split("&");
            let obj = {};
            for (let key in data) {
                obj[data[key].split("=")[0]] = data[key].split("=")[1];
            }
            return JSON.stringify(obj);
        }
    }
}