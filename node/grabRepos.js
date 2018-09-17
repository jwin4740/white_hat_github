var GitHub = require('github-api');
let username = process.argv[2];
let oathtoken = process.argv[3];
console.log(oathtoken);
var gh = new GitHub({
    token: oathtoken
});

var me = gh.getUser(username);
let repoArr = [];
me.listRepos({}, function (err, repos) {
    if (err) throw err;
    repoArr = repos.map(function (val) {
        return val.name
    });
    console.log(repoArr);
});
