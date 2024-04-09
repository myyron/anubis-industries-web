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

        $("#deleteProduct").on("click", function () {
            bootbox.confirm({
                title: 'Delete product?',
                message: 'This action will delete the product and all associated data with it.',
                buttons: {
                    cancel: {
                        label: '<i class="fa fa-times"></i> Cancel'
                    },
                    confirm: {
                        label: '<i class="fa fa-check"></i> Confirm'
                    }
                },
                callback: function (result) {
                    if (result) {
                        $.ajax({
                            url: "/product/delete",
                            contentType: "application/json",
                            type: "post",
                            dataType: "json",
                            data: productTable.row('.selected').data().alias
                        }).always(function () {
                            productTable.ajax.reload();
                            $("#deleteProduct").addClass("disabled");
                        });
                    }
                }
            });
        });

        $("#saveNewProductButton").on("click", function () {
            $.ajax({
                url: "/product/add",
                contentType: "application/json",
                type: "post",
                dataType: "json",
                data: createDtoFromForm(document.querySelectorAll('#addProductForm input'))
            }).always(function () {
                $("#addProductModal").modal("hide");
                productTable.ajax.reload();
                $("#addProductForm")[0].reset();
                $("#variationList").empty();
            });
        });

        productTable.on('click', 'tbody tr', (e) => {
            let classList = e.currentTarget.classList;
            if (classList.contains('selected')) {
                classList.remove('selected');
                $("#editProduct").addClass("disabled");
                $("#deleteProduct").addClass("disabled");
            } else {
                productTable.rows('.selected').nodes().each((row) => row.classList.remove('selected'));
                classList.add('selected');
                $("#editProduct").removeClass("disabled");
                $("#deleteProduct").removeClass("disabled");
            }
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