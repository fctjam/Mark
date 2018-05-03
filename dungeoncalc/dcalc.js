//variables relating to the kill counter box
var guide;
var killcount = 0;
var totalkc;
var remainingkc;
var agrocount = 0;
var thrashcount = 0;
var domacount = 0;
var mephicount = 0;

//mouse interaction placeholder variables
var d;
var hoverbox;
var hovertext;

//mode variables
var mLOAD = 0;
var mONE = 1;
var mTWO = 2;
var mTHREE = 3;
var mFOUR = 4;
var mFIVE = 5;
var mode = mLOAD;

// mob indexes
var agronax = 0;
var thrashbite = 1;
var domatrax = 2;
var mephistroth = 3;
var felguard = 4;
var eredar = 5;
var felbat = 6;
var broodqueen = 7;
var hound = 8;
var gazerax = 9;
var nightborne = 10;

//Array of mobs
var mobTypes = [
	{
		name: "Agronax",
		worth: "Dungeon Boss",
		difficulty: "Hard",
		notes: "Formerly a gentle Ancient, the corrupted Agronax now defends the Twilight Grove for the Burning Legion.",
		killcnt : 0,
		killval: 0,
		imageUrl: "https://s10.postimg.cc/3qzr45g6x/Agronax_Marker.png",
		imageObj: null
	},
	{
		name: "Thrashbite the Scornful",
		worth: "Dungeon Boss",
		difficulty: "Medium",
		notes: "Thrashbite may pack a big punch, but he's quite slow. It's easy to outrun him and wear him down.",
		killcnt : 0,
		killval: 0,
		imageUrl: "https://s10.postimg.cc/ob4l2nbdl/Thrashbite_Marker.png",
		imageObj: null
	},
	{
		name: "Domatrax",
		worth: "Dungeon Boss",
		difficulty: "Very Hard",
		notes: "Domatrax is Mephistroth's last line of defense. Shut down his portals before he can summon reinforcements.",
		killcnt : 0,
		killval: 0,
		imageUrl: "https://s10.postimg.cc/vr3uofrd5/Domatrax_Marker.png",
		imageObj: null
	},
	{
		name: "Mephistroth",
		worth: "Dungeon Boss",
		difficulty: "Very Hard",
		notes: "Mephistroth commands the demons of the Cathedral, and twists the shadows around him to confuse and subdue his foes.",
		killcnt : 0,
		killval: 0,
		imageUrl: "https://s10.postimg.cc/68bibfn8p/Mephistroth_Marker.png",
		imageObj: null
	},
	{
		name: "Felguard Shieldbearer",
		worth: "10%",
		difficulty: "Medium",
		notes: "These experienced Felguards always have Eredar Soulmenders ready to heal them.",
		killcnt : 0,
		killval: 10,
		imageUrl: "https://s10.postimg.cc/td1qw1i0p/felguard.png",
		imageObj: null
	},
	{
		name: "Eredar Felbringer",
		worth: "7%",
		difficulty: "Medium",
		notes: "These Eredar are strong warriors, and usually have Felhounds defending them.",
		killcnt : 0,
		killval: 7,
		imageUrl: "https://s10.postimg.cc/k59ifcqe1/eredar.png",
		imageObj: null
	},
	{
		name: "Vicious Felbat",
		worth: "5%",
		difficulty: "Easy",
		notes: "While these bats fly in packs, they're relatively easy to cleave down.",
		killcnt : 0,
		killval: 5,
		imageUrl: "https://s10.postimg.cc/or5mnoh21/felbat.png",
		imageObj: null
	},
	{
		name: "Broodqueen Ven'orn",
		worth: "15%",
		difficulty: "Hard",
		notes: "Ven'orn and her spiders are powerful foes. Dispel your party members so they don't die of poisoning.",
		killcnt : 0,
		killval: 10,
		imageUrl: "https://s10.postimg.cc/5ytrk3cy1/Brood_Mother.png",
		imageObj: null
	},
	{
		name: "Felhounds and Imps",
		worth: "8%",
		difficulty: "Medium",
		notes: "These Legion beasts can overwhelm unprepared adventurers, but when stunned are fairly vulnerable.",
		killcnt : 0,
		killval: 8,
		imageUrl: "https://s10.postimg.cc/e8a8cpe6x/hound.png",
		imageObj: null
	},
	{
		name: "Gazerax",
		worth: "10%",
		difficulty: "Medium",
		notes: "Gazerax can emit powerful blasts of light from his eyes. Make sure to face away from him when his eyes light up.",
		killcnt : 0,
		killval: 10,
		imageUrl: "https://s10.postimg.cc/5m2ddxa3t/gazerax.png",
		imageObj: null
	},
	{
		name: "Nightborne Spellblades",
		worth: "12%",
		difficulty: "Hard",
		notes: "A group of elite Nightborne guard the final stairwell. Be sure to dodge their fel orb attacks.",
		killcnt : 0,
		killval: 15,
		imageUrl: "https://s10.postimg.cc/ptft68n0p/nightborne.png",
		imageObj: null
	}
	];

// Array of floors
var floors = [
{
	imageUrl:"https://s10.postimg.cc/70gimqbe1/loadscreen_tombofsargerasraid_wide_F.jpg",
	imageObj: null,
	floormobs: null
},
{
	imageUrl:"https://s10.postimg.cc/xdt29k0t5/Co_EN_First_Floor.jpg",
	imageObj: null,
	floormobs: null
},
{
	imageUrl:"https://s10.postimg.cc/7i9bqcr9l/Co_EN_Second_Floor.jpg",
	imageObj: null,
	floormobs: null
},
{
	imageUrl:"https://s10.postimg.cc/4bes6qtyx/Co_EN_Third_Floor.jpg",
	imageObj: null,
	floormobs: null
},
{
	imageUrl:"https://s10.postimg.cc/637r1n5m1/Co_EN_Fourth_Floor.jpg",
	imageObj: null,
	floormobs: null
},
{
	imageUrl:"https://s10.postimg.cc/xdt29jldl/Co_EN_Fifth_Floor_Mephistroth.jpg",
	imageObj: null,
	floormobs: null
}
];
    
    	// array of first floor mobs
    	floors[1].floormobs = [
    		{
    			type : felguard,
    			clicked : false,
    			x : 346,
    			y : 343,
    			width : 25,
    			height : 25
    		},
    		{
    			type : felguard,
    			clicked : false,
    			x : 463,
    			y : 325,
    			width : 25,
    			height : 25
    		},
    		{
    			type : felbat,
    			clicked : false,
    			x : 508,
    			y : 248,
    			width : 25,
    			height : 25
    		},
    		{
    			type : eredar,
    			clicked : false,
    			x : 461,
    			y : 165,
    			width : 25,
    			height : 25
    		},
    		{
    			type : felguard,
    			clicked : false,
    			x : 388,
    			y : 156,
    			width : 25,
    			height : 25
    		}
    	];
    
    	floors[2].floormobs = [
    		{
    			type : agronax,
    			clicked : false,
    			x : 400,
    			y : 205,
    			width : 70,
    			height : 60
    		},
    		{
    			type : nightborne,
    			clicked : false,
    			x : 303,
    			y : 220,
    			width : 25,
    			height : 25
    		},
    		{
    			type : eredar,
    			clicked : false,
    			x : 343,
    			y : 331,
    			width : 25,
    			height : 25
    		}
    	];
    
    	floors[3].floormobs = [
    		{
    			type : thrashbite,
    			clicked : false,
    			x : 370,
    			y : 280,
    			width : 70,
    			height : 60
    		},
    		{
    			type : hound,
    			clicked : false,
    			x : 390,
    			y : 200,
    			width : 25,
    			height : 25
    		},
    		{
    			type : hound,
    			clicked : false,
    			x : 390,
    			y : 258,
    			width : 25,
    			height : 25
    		},
    		{
    			type : gazerax,
    			clicked : false,
    			x : 390,
    			y : 338,
    			width : 25,
    			height : 25
    		},
    		{
    			type : hound,
    			clicked : false,
    			x : 390,
    			y : 388,
    			width : 25,
    			height : 25
    		}
    	];
    
    	floors[4].floormobs = [
    		{
    			type : nightborne,
    			clicked : false,
    			x : 355,
    			y : 171,
    			width : 25,
    			height : 25
    		},
    		{
    			type : broodqueen,
    			clicked : false,
    			x : 355,
    			y : 238,
    			width : 25,
    			height : 25
    		}
    	];
    
    	floors[5].floormobs = [
    		{
    			type : domatrax,
    			clicked : false,
    			x : 373,
    			y : 100,
    			width : 70,
    			height : 200
    		},
    		{
    			type : mephistroth,
    			clicked : false,
    			x : 373,
    			y : 90,
    			width : 70,
    			height : 200
    		},
    		{
    			type : felbat,
    			clicked : false,
    			x : 390,
    			y : 176,
    			width : 25,
    			height : 25
    		}
    	];
    
//load images
function setup() {
  createCanvas(765, 517);
  
  //load floor images from external website
  for (i = 0; i < floors.length; i++) {
	  floors[i].imageObj = loadImage(floors[i].imageUrl);
  }
  
  // load mob images
  for (i = 0; i < mobTypes.length; i++) {
	  mobTypes[i].imageObj = loadImage(mobTypes[i].imageUrl);
  }
}

function draw() {
  background(220);
  
  // load floor background
  image(floors[mode].imageObj,0, 0, 765, 517);

  //load mobs for floor we are on
  if (floors[mode].floormobs != null) {
  	for (i = 0; i < floors[mode].floormobs.length; i++) {
  		mob = floors[mode].floormobs[i];
	  	image(mobTypes[mob.type].imageObj, mob.x, mob.y, mob.width, mob.height);
  	}
  }
  
  buttonHover();
  
  //if statement to create kill count box on all map screens
  if (mode != mLOAD) {
	  displayScore();
  } 
  else {
	  entryPage();
  }
}


// check if a point is close to current mouse location
function isClose(x,y) {
	if (dist(mouseX, mouseY, x, y) < 12.5) {
		return true;
	}
	else {
		return false;
	}
}
	
//keyPressed function to swap between floors
function keyPressed() {
  if (keyCode === LEFT_ARROW) {
    mode = (mode - 1);
  } else if (keyCode === RIGHT_ARROW) {
    mode = (mode + 1);
  }
  if (mode < 0) {
    mode = 0;
  } else if (mode > 5) {
    mode = 5;
  }
}

//mousePressed function to update kill count guide
function mousePressed() {
	// loop for mobs on the current floor
  	if (floors[mode].floormobs != null) {
  		for (i = 0; i < floors[mode].floormobs.length; i++) {
  			mob = floors[mode].floormobs[i];
  		    d = dist(mouseX, mouseY, mob.x+(mob.width/2), mob.y+(mob.height/2));
  		    // if distance is small, we are clicking this mob
  		    if (d < 12.5) {
  		    	// if we have not clicked on this mob ...
  		    	if (!mob.clicked) {
  		    		// update killnct for this mob, and overall kill count
  		    		mobTypes[mob.type].killcnt++;
  		    		killcount += mobTypes[mob.type].killval;
  		    		mob.clicked = true;
  		    	}
  		    } 			
  		}
  	}
	
  //reset button
  d = dist(mouseX, mouseY, 105, 397.5);
  if (d < 51.5) {
      mode = mLOAD;
      // reset the click check for all mobs
      for (i = 1; i < floors.length; i++) {
      	for (j = 0; j < floors[i].floormobs.length; j++) {
  			floors[i].floormobs[j].clicked = false;
      	}
      }
      //reset the kill counts for each mob type
      for (i = 0; i < mobTypes.length; i++) {
    	  mobTypes[i].killcnt = 0;
      }
      
      // rest overall kill count
      killcount = 0;
      
  }
}

//function that detects mouse overs and displays an info box
function buttonHover() {
  fill (75, 134, 229);
  stroke (0,0,0);
  strokeWeight(.5);

  // if you're in the loading page, just return
  if (mode < 1) {
	  return;
  }
  
  // loop for mobs on the current floor
  for (i = 0; i < floors[mode].floormobs.length; i++) {
	  mob = floors[mode].floormobs[i];
	  // if distance is small, we are hovering this mob
	  if (isClose(mob.x +(mob.width/2), mob.y + (mob.height/2))) {
		  hoverbox = rect(mouseX + 20, mouseY, 120, 120);
	      fill (0, 0, 0);
	      textSize(10);
	      textAlign(LEFT);
	      text(mobTypes[mob.type].name, mouseX + 25, mouseY + 5, 115, 115);
	      noStroke();
	      text("Worth: " + mobTypes[mob.type].worth, mouseX + 25, mouseY + 20, 115, 115);
	      text("Difficulty: " + mobTypes[mob.type].difficulty, mouseX + 25, mouseY + 35, 115, 115);
	      text("Notes: " + mobTypes[mob.type].notes, mouseX + 25, mouseY + 50, 115, 115);
	  }
  }
		  
  strokeWeight(1);
}

function displayScore() {
  	fill (84, 158, 77);
    stroke (0,0,0);
  	rect (15, 175, 185, 175);
    fill (198, 47, 55);
    rect (55, 385, 100, 25);
    noStroke();
  
  	fill (0, 0, 0);
    textSize(24);
    textAlign(CENTER);
    text (" RESET", 55, 385, 100, 25);
  	textSize(14);
    textAlign(LEFT);
    totalkc = "Total Kill Count: " + killcount + "%";
    if (killcount > 100) {
      totalkc = "Total Kill Count: 100%";
    }
  	text(totalkc, 20, 180, 185, 200);
  	remainingkc = "Kill Count Needed: " + (100 - killcount) + "%";
    if (killcount > 100) {
      remainingkc = "Extra Kill Count: " + (killcount - 100) + "%";
    } 
  	text(remainingkc, 20, 210, 185, 200);
    text("Agronax: " + mobTypes[agronax].killcnt + "/1", 20, 240, 185, 200);
    text("Thrashbite: " + mobTypes[thrashbite].killcnt + "/1", 20, 270, 185, 200);
    text("Domatrax: " + mobTypes[domatrax].killcnt + "/1", 20, 300, 185, 200);
    text("Mephistroth: " + mobTypes[mephistroth].killcnt + "/1", 20, 330, 185, 200);

}

function entryPage() {
    //instructions on loading screen
    fill (84, 158, 77);
    stroke (0,0,0);
  	rect (370, 10, 300, 75);
    rect (15, 400, 735, 100);
    noStroke();
    
    fill (0, 0, 0);
  	textSize(26);
    textAlign(CENTER);
  	text("Interactive Cathedral of Eternal Night Map", 375, 15, 295, 70);
    text("Instructions", 15, 400, 735, 100);
    textSize(18);
    textAlign(LEFT);
    text("Use the Left and Right arrow keys to cycle through the different floors of the Cathedral.", 20, 405, 280, 400);
    text("Click on the mob icons to plan your path through the dungeon. The box on the left will show you how much kill count you still need.", 460, 405, 280, 400);
    noFill();
    stroke(0,0,0);
    rect(305, 400, 145, 30);
    noStroke();
}

