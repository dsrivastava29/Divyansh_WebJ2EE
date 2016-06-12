//User validations
function check(field) {
    //replace unknown chars to space
    field.value = field.value.replace(/[`~!@#$%^&*()_|+\-=?;:'",.<>\{\}\[\]\\\/]/gi, '');
}