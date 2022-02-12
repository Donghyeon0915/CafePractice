/*=====-------------------------- DRAG and DROP --------------------------=====*/
const dropItem = document.getElementById('drop-item');

new Sortable(dropItem, {
    animation: 350,
    chosenClass: 'sortable-chosen',
    dragClass: 'sortable-drag'
})