console.log("My toast has been loaded.")
const TYPES = ['info', 'warning', 'success', 'error'],
    TITLES = {
        'info': 'Notice!',
        'success': 'BINGO!',
        'warning': 'Watch Out!',
        'error': 'NO!'
    },
    CONTENT = {
        'info': 'Hello, world! This is a toast message.',
        'success': 'The action has been completed.',
        'warning': 'It\'s all about to go wrong',
        'error': 'It all went wrong.'
    },
    POSITION = ['top-right', 'top-left', 'top-center', 'bottom-right', 'bottom-left', 'bottom-center'];

$.toastDefaults.position = 'top-center';
$.toastDefaults.dismissible = true;
$.toastDefaults.stackable = true;
$.toastDefaults.pauseDelayOnHover = true;
$.toastDefaults.delay = 5000;

// type是 ['info', 'warning', 'success', 'error']中的一个
function showToast(type, title, content) {

    // $.snack(type, content);

    $.toast({
        type: type,
        title: title,
        // subtitle: '11 mins ago',
        content: content,
        delay: 2000
    });
}

function showSnack(type, content) {
    $.toast({
        type: type,
        title: content,
        delay: 2000
    });
}

showToast("success", "1", "asd")