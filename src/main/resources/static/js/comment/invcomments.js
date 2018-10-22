/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function () {
    console.log('jquerycomments.js script executed');
    $("#feature-comments").comments({
        profilePictureURL: 'https://viima-app.s3.amazonaws.com/media/user_profiles/user-icon.png',
        roundProfilePictures: true,
        textareaRows: 1,
        enableAttachments: true,
        enableHashtags: true
    });
});