
var HTMLEditor = Ext.extend(Ext.form.HtmlEditor, {
addImage : function() {
   var editor = this;
   
   var imgform = new Ext.FormPanel({
    region : 'center',
    labelWidth : 55,
    frame : true,
    bodyStyle : 'padding:5px 5px 0',
    autoScroll : true,
    border : false,
    fileUpload : true,
    items : [{
       xtype : 'textfield',
       fieldLabel : '选择文件',
       name : 'userfile',
       id : 'userfile',
       inputType : 'file',
       allowBlank : false,
       blankText : '文件不能为空',
       height : 25,
       anchor : '98%'
      }],//items end
    buttons : [{
     text : '上传',
     type : 'submit',
     handler : function() {
      var furl="";
      furl=imgform.form.findField('userfile').getValue();
      var type=furl.substring(furl.length-3).toLowerCase();
      var filename=furl.substring(furl.lastIndexOf("\\")+1);
      if (furl==""||furl==null) {return;}
      if(type!='jpg'&&type!='bmp'&&type!='gif'&&type!='png'){
       alert('仅支持jpg、bmp、gif、png格式的图片');
       return;
      }
      imgform.form.submit({
       url : '/newsinfo.mvc/AddFiles_newsinfo',
       waitMsg : '正在上传......',
       waitTitle : '请等待',
       method : 'POST',
       success : function() {
        var element = document.createElement("img");
        element.src = "../UploadFile/"+filename;
        element.style.width="300px";
             element.style.height="200px";
        if (Ext.isIE) {
         editor.insertAtCursor(element.outerHTML);
        } else {
         var selection = editor.win.getSelection();
         if (!selection.isCollapsed) {
          selection.deleteFromDocument();
         }
         selection.getRangeAt(0).insertNode(element);
        }
        win.close();
       },
       failure : function(form, action) {
        form.reset();
        if (action.failureType == Ext.form.Action.SERVER_INVALID)
         Ext.MessageBox.alert('警告',
           '上传失败，仅支持jpg、bmp、gif、png格式的图片');
       
       }
      
      });//imgform.form.submit end
     }//handler end
    }, {
     text : '关闭',
     type : 'submit',
     handler : function() {
      win.close(this);
     }
    }]//buttons end
   })//imgform end

   var win = new Ext.Window({
      title : "上传图片",
      id : 'picwin',
      width : 400,
      height : 120,
      modal : true,
      border : false,
      iconCls:'icon-uploadpic',
      layout : "fit",
      items : imgform

     });
   win.show();
  
},//上传图片的扩展 addImage end
addFile : function() {
   var editor = this;
   var fileform = new Ext.FormPanel({
    region : 'center',
    labelWidth : 55,
    frame : true,
    bodyStyle : 'padding:5px 5px 0',
    autoScroll : true,
    border : false,
    fileUpload : true,
    items : [{
       xtype : 'textfield',
       fieldLabel : '选择文件',
       name : 'userfile_F',
       id : 'userfile_F',
       inputType : 'file',
       allowBlank : false,
       blankText : '文件不能为空',
       height : 25,
       anchor : '98%'
      }],//items end
    buttons : [{
     text : '上传',
     type : 'submit',
     handler : function() {
      var furl="";//文件物理地址
      var fname="";//文件名称
      furl=fileform.form.findField('userfile_F').getValue();
      var type=furl.substring(furl.length-3).toLowerCase();
      if (furl==""||furl==null) {return;}
      if(type!='doc'&&type!='xls'){
       alert('仅支持上传doc、xls格式的文件!');
       return;
      }
      fname=furl.substring(furl.lastIndexOf("\\")+1);
      fileform.form.submit({
       url : '/newsinfo.mvc/AddFiles_newsinfo',
       waitMsg : '正在上传......',
       waitTitle : '请等待',
       method : 'POST',
       success : function() {
        var element = document.createElement("a");
        element.href = "../UploadFile/"+fname;
        element.target = '_blank';
        element.innerHTML = fname;
        if (Ext.isIE) {
         editor.insertAtCursor(element.outerHTML);
        } else {
         var selection = editor.win.getSelection();
         if (!selection.isCollapsed) {
          selection.deleteFromDocument();
         }
         selection.getRangeAt(0).insertNode(element);

        }
        winFile.close();
       },//success end
       failure : function() {
        form.reset();
        if (action.failureType == Ext.form.Action.SERVER_INVALID)
         Ext.MessageBox.alert('警告',
           '上传失败，仅支持上传doc、xls格式的文件!');
       
       }//failure end
      
      });//fileform.form.submit
     }
    }, {
     text : '关闭',
     type : 'submit',
     handler : function() {
      winFile.close(this);
     }//handler end
    }]//buttons end
   })

   var winFile = new Ext.Window({
      title : "上传附件",
      id : 'picwin',
      width : 400,
      height : 120,
      modal : true,
      border : false,
      layout : "fit",
      iconCls : 'icon-uploadfile',
      items : fileform

     });
   winFile.show();
  
},//上传附件的扩展  addFile end
createToolbar : function(editor) {
   HTMLEditor.superclass.createToolbar.call(this, editor);
   this.tb.insertButton(16, {
      cls : "x-btn-icon",
      iconCls : "icon-uploadpic",
      handler : this.addImage,
      tooltip : "添加图片",
      scope : this
     });
   this.tb.insertButton(17, {
      cls : "x-btn-icon",
      iconCls : 'icon-uploadfile',
      handler : this.addFile,
      tooltip : "添加文件",
      scope : this
     });
}
});//HTMLEditor end
Ext.reg('DCJSEditor', HTMLEditor);
