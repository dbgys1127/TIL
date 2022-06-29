import { DATA, generateNewTweet } from "./data.js";
// DATA는 이미 작성된 트윗을 표시합니다.
console.log(DATA);

Number.prototype.padLeft = function () {
  if (this < 10) {
    return "0" + String(this);
  } else {
    return String(this);
  }
};

Date.prototype.format = function () {
  var yyyy = this.getFullYear();
  var month = (this.getMonth() + 1).padLeft();
  var dd = this.getDate().padLeft();
  var HH = this.getHours().padLeft();
  var mm = this.getMinutes().padLeft();
  var ss = this.getSeconds().padLeft();

  var format = [yyyy, month, dd].join("-") + " " + [HH, mm, ss].join(":");
  return format;
};
// generateNewTweet을 호출할 때마다 새로운 트윗을 생성합니다.
console.log(generateNewTweet());

const state = {
  isFilteredPage: false
};

const usernameInput = document.querySelector("#usernameInput");
const messageInput = document.querySelector("#messageInput");
const tweetButton = document.querySelector("#tweetButton");
const randomButton = document.querySelector("#randomButton");
const mainTweetList = document.querySelector("#tweetlist");

const tweetListReducer = function (ul, tweet, id) {
  const li = document.createElement("li");
  li.classList.add("tweet");
  li.classList.add("white");

  const user = document.createElement("span");
  const createdAt = document.createElement("div");
  const message = document.createElement("div");

  user.classList.add("tweet__username");
  user.textContent = tweet.user;
  user.addEventListener("click", handleClickUser);

  const createdAtContent = document.createElement("span");
  createdAt.classList.add("tweet__createdAt");
  createdAtContent.textContent = tweet.created_at;
  createdAt.append(createdAtContent);

  message.classList.add("tweet__message");
  message.textContent = tweet.message;

  li.append(user, createdAt, message);
  ul.append(li);
  return ul;
};

const renderDATA = function () {
  const ul = document.createElement("ul");
  ul.id = "tweetWrapper";

  const tweets = DATA.reduce(tweetListReducer, ul);

  state.isFilteredPage = false;
  mainTweetList.append(tweets);
};

const renderFilteredDATA = function (targetName) {
  const ul = document.createElement("ul");
  ul.id = "tweetWrapper";

  const tweets = DATA.filter(function (tweet) {
    return tweet.user === targetName;
  }).reduce(tweetListReducer, ul);

  state.isFilteredPage = true;
  mainTweetList.append(tweets);
};

const removeTweet = function () {
  const tweetWrapper = document.querySelector("#tweetWrapper");
  tweetWrapper.remove();
};

const handleClickUser = function (event) {
  const targetName = event.target.textContent;
  alert(`${targetName} 필터링 결과입니다.`);
  removeTweet();
  renderFilteredDATA(targetName);
};

// 버튼을 모두 완성한 후 주석을 제거하시면 트윗리스트를 볼 수 있습니다.
tweetButton.onclick = function () {
  if (usernameInput.value && messageInput.value) {
    const tweetObject = {};
    tweetObject.user = usernameInput.value;
    tweetObject.message = messageInput.value;
    tweetObject.created_at = new Date().format();
    DATA.unshift(tweetObject);
    removeTweet();
    renderDATA();
    usernameInput.value = "";
    messageInput.value = "";
  } else {
    alert("User와 Message를 모두 입력하세요.");
  }
};

randomButton.addEventListener("click", function () {
  const tweetObject = generateNewTweet();
  DATA.unshift(tweetObject);
  removeTweet();
  renderDATA();
});

renderDATA();
