// JavaScript Document
DCC.robot.David=Ext.extend(Ext.app.RobotModule,{
    id:'david-robot-win',
	
	currGameId:'',
	
	currCodeFile:'',
	
	currCode:'',
	
	gameStore:[],

	//代码文件储存结构
	codeFile:[],
	/*codeFile:[{
		codeFileName:'',//文件名
		codeFilePath:'',//文件地址
		code:'',//代码内容
		gameId:'',//指向游戏id
		gameName:''//指向游戏名
		active:false//是否为活动代码
	}],*/
	init : function(){
		var json = new Ext.data.Store({
			reader:new Ext.data.ArrayReader({},[
			   {name:'gameId'},
			   {name:'gameName'},
			   {name:'codeFilePath'},
			   {name:'codeFileName'}
			]),
			data:DCC.data.RobotCode
			//autoLoad:true
		});

		for(var i=0;i<json.getCount();i++){
			var codeFile = new Object();
			var obj = json.getAt(i);
			codeFile.gameId = obj.get('gameId');
			codeFile.gameName = obj.get('gameName');
			codeFile.codeFileName = obj.get('codeFileName');
			codeFile.codeFilePath = obj.get('codeFilePath');
			this.codeFile.push(codeFile);
			
			var gs = [obj.get('gameId'),obj.get('gameName')];
			var isHas = false;
			for(var j=0;j<this.gameStore.length;j++){
				if(this.gameStore[j][0] == gs[0]){
					isHas = true;
					break;
				}
			}
			if(!isHas && this.gameStore.indexOf(gs) == -1){
				this.gameStore.push(gs);
			}
		}
	},//init end
	info_label:{
		xtype:'label',
		text:'hello!',
		width:180,
		height :50
	},//info_label end

	initUI:function(){
		
	},//initUI end
	
	config:function(t){
		
		var gameCombo = new Ext.form.ComboBox({
			mode:'local',
			editable:false,
			store:t.gameStore,
			forceSelection: true,//必须选择一项  
           	emptyText:'Select Game',//默认值
			triggerAction: 'all',
			region:'north',
			listeners:{    
            	select : function(combo, record,index){
					codeList.removeAll();
					t.currGameId = record.json[0];
                	for(var i=0;i<t.codeFile.length;i++){
						if(t.codeFile[i].gameId == record.json[0]){
							codeList.add({
								xtype:'button',
								width:'100%',
								text:t.codeFile[i].codeFileName,
								listeners:{
									click:function(){
										var buttons = codeList.items;
										buttons.each(function(){
											this.setText(Ext.util.Format.stripTags(this.getText()));
										});
										this.setText('<span style=\'color:#ff0000\'>'+this.getText()+'</span>');
										for(var j=0;j<t.codeFile.length;j++){
											if(t.codeFile[j].gameId == record.json[0]){
												t.currCodeFile = t.codeFile[j].codeFilePath+Ext.util.Format.stripTags(this.text);
												//alert((t.currCodeFile));
											}
										}
									}
								}
							});
						}
					}
					codeList.doLayout();
            	}
        	}
		});
		var codeList = new Ext.Panel({
			autoScroll:true,
			region:'center'
			//layout:'vbox'
		});
		var ok_btn = new Ext.Button({
			text:'OK',
			region:'south',
			handler:function(){
				//alert(this.currGameId);
				//alert(this.currCodeFile);
				_toolTip ='<HTML>'+'Click me to run game<BR>'+'gameId:'+this.currGameId+'<BR>codeFile:'+this.currCodeFile+'</HTML>';
				MyDesktop.getDesktop().getWindow('david-robot-win').items.itemAt(0).setTooltip(_toolTip);
				win.close();
			}.createDelegate(this)
		});
		var win = new Ext.Window({
			id: 'david-robot-config-win',
			title: 'David Robot Config',
			width:200,
			height:150,
			iconCls: 'icon-david-robot',
			shim:false,
			animCollapse:true,
			autoScroll:true,
			constrainHeader:true,
			maximizable:false,
			closable:false,
			resizable:false,
			draggable:false,
			layout:'border',
			items:[gameCombo,codeList,ok_btn]
		});
		win.show();
		return win;
	},//config end
	
	selectGame:function(){
		
	},//selectGame end
	
	loadCode:function(){
		
	},//loadCode end
	
	run:function(){
		
	},
	
	createWindow:function(){
		var desktop = MyDesktop.getDesktop();
        var _win = desktop.getWindow('david-robot-win');
		if(!_win){
			 _win = desktop.createWindow({
				id: 'david-robot-win',
				title: 'David Robot',
				width:200,
				height:150,
				iconCls: 'icon-david-robot',
				shim:false,
				animCollapse:true,
				constrainHeader:true,
				maximizable:false,
				closable:false,
				resizable:false,
				
				layout:'absolute',
				border:false,
				bbar:[this.info_label],
				items:[{
					id:'robot-david-button-run',
					iconCls:'robot-david-button-run-icon',
					xtype:'button',
					x:40,
					y:10,
					width:80,
					height:80,
					tooltip:'No game selected',
					handler:function(){
						MyDesktop.getDesktop().openModule(this.currGameId,true,'editor',this.currCodeFile)
						//MyDesktop.getModule('robot-win-editor').runSource();
					}.createDelegate(this)
				},{
					id:'robot-david-button-cfg',
					iconCls:'robot-david-button-cfg-icon',
					xtype:'button',
					scale:'medium',
					x:130,
					y:65,
					tooltip:'Click me to select code of game',
					handler:function(){
						var cfgWin = this.config(this);
						cfgWin.setPosition(_win.x,_win.y);
					}.createDelegate(this)
				}]
			})
		}
		var availWidth = Ext.get('x-desktop').getWidth(true);
		var availHeight = Ext.get('x-desktop').getHeight(true);
		var width = _win.getWidth();
		var height = _win.getHeight();
		var x = availWidth - width-10;
		var y = availHeight -height-10;
		
		_win.setPosition(x,y);
		_win.show();
	},//createWindow end
});