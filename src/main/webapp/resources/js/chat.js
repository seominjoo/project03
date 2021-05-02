const url = 'http://localhost:8080/fleamarket';
let stompClient;
let selectedUser;
let newMessages = new Map();

function connectToChat(userName) {
    console.log("connecting to chat...")
    let socket = new SockJS(url + '/ws');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        console.log("connected to: " + frame);
        stompClient.subscribe("/topic/messages/" + userName, function (response) {
            let data = JSON.parse(response.body);
            
            console.log(data.senderId);
            
            if (selectedUser === data.senderId) {
                render(data.content, data.senderId);
            } else {
                newMessages.set(data.senderId, data.content);
                $('#userNameAppender_' + data.senderId).append('<span id="newMessage_' + data.senderId + '" style="color: red">+1</span>');
            }
        });
    });
}

function sendMsg(from, text) {
    stompClient.send("/app/chat/" + selectedUser, {}, JSON.stringify({
        senderId: from,
        receiverId: selectedUser,
        content: text
    }));
}

function selectUser(userName) {
    console.log("selecting users: " + userName);
    selectedUser = userName;
    
    $('li').remove("#chat-contents");
    
    recallChat(selectedUser);
    
    let isNew = document.getElementById("newMessage_" + userName) !== null;
    if (isNew) {
        let element = document.getElementById("newMessage_" + userName);
        element.parentNode.removeChild(element);
        render(newMessages.get(userName), userName);
    }
    $('#selectedUserId').html('');
    $('#selectedUserId').append('Chat with ' + userName);
      
}

function recallChat(selectedUser) {
	$.get(url + "/recallChat/" + selectedUser, function (response){
		let messages = response;
			
		console.log(messages);
	});
}
