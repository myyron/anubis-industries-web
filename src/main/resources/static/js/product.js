class Product {

    constructor() {
        const productTable = new DataTable('#productTable', {
            ajax: {
                url: '/product/list',
                dataSrc: ''
            },
            columns: [
                {data: 'alias'},
                {data: 'name'},
                {data: 'variation[,].name'}
            ]
        });

        $("#addVariation").on("click", function () {
            $("#variationList").append('<div class="row mb-3"><div class="col"><input type="text" name="variation.name" class="form-control"></div></div>');
        });

        $("#saveNewProductButton").on("click", function () {
            $.ajax({
                url: "/product/add",
                contentType: "application/json",
                type: "post",
                dataType: "json",
                data: createDtoFromForm(document.querySelectorAll('#addProductForm input')),
                success: function (data) {
                    $("#addProductModal").modal("hide");
                    productTable.ajax.reload();
                }
            });
        });

        function createDtoFromForm(elements) {
            const data = {};
            for (let i = 0; i < elements.length; i++) {
                let el = elements[i];
                let val = el.value;
                let fullname = el.getAttribute("name");
                if (!fullname)
                    continue;

                if (fullname === "alias") {
                    data[fullname] = val;
                    continue;
                }
                if (fullname === "name") {
                    data[fullname] = val;
                    continue;
                }
                if (fullname === "variation.name") {
                    if (!data["variation"]) {
                        data["variation"] = [];
                    }
                    let obj = {"name": val};
                    data["variation"].push(obj);
                    continue;
                }
            }
            let result = JSON.stringify(data);
            console.log(result);
            return result;
        }
    }
}