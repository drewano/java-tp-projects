function updateTotals() {
    let totalGlobal = 0;
    const table = document.getElementById("pizzasTable");
    const rows = table.querySelectorAll("tbody tr");

    rows.forEach(function(row) {
        const slider = row.querySelector("input[type='range']");
        const quantity = parseInt(slider.value);

        const qtySpan = row.querySelector("span[id^='qty-']");
        qtySpan.innerText = quantity;

        const price = parseFloat(row.cells[3].innerText);

        const lineTotal = quantity * price;
        const totalSpan = row.querySelector("span[id^='total-']");
        totalSpan.innerText = lineTotal.toFixed(2);

        totalGlobal += lineTotal;
    });

    document.getElementById("orderTotal").innerText = "Total : " + totalGlobal.toFixed(2) + " €";
}
