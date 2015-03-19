
function generate(x, y) {
  var range = y - x + 1;
  return Math.floor(Math.random() * range) + x;
}

parms = new Array(10);
parms[0] = "s_serial=e4e4ca53d574bdfe6dd2d9cbf9cd55fa";
parms[1] = "title=" + escape(document.title);
parms[2] = "url=" + escape(window.document.URL);
parms[3] = "cookie=" + (navigator.cookieEnabled ? "yes" : "no");
parms[4] = "userlang=" + (navigator.appName == "Netscape" ? navigator.language : navigator.userLanguage);
parms[5] = "referrer=" + escape(window.document.referrer);
if (typeof(screen) == "object") {
  parms[6] = "screen_width=" + screen.width;
  parms[7] = "screen_height=" + screen.height;
  parms[8] = "screen_color=" + screen.colorDepth;
}

parms[9] = "l_serial=none";
parms[10] = "time=1134071532";

var p = "";
for (i = 0; i < parms.length; i++) {
  if (i > 0) {
    p += "&";
  }
  p += parms[i];
}


document.write("<img src=http://stat.cliche.se/run_counter.php?" + p + " border=0>");
