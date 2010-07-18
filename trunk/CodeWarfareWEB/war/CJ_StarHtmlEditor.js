/**
* ���ߣ��½�
* QQ : 710782046
* Email:ovenjackchain@gmail.com
* Blog :http://hi.baidu.com/jackvoilet
*/ 
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
       fieldLabel : 'ѡ���ļ�',
       name : 'userfile',
       id : 'userfile',
       inputType : 'file',
       allowBlank : false,
       blankText : '�ļ�����Ϊ��',
       height : 25,
       anchor : '98%'
      }],
    buttons : [{
     text : '�ϴ�',
     type : 'submit',
     handler : function() {
      var furl="";
      furl=imgform.form.findField('userfile').getValue();
      var type=furl.substring(furl.length-3).toLowerCase();
      var filename=furl.substring(furl.lastIndexOf("\\")+1);
      if (furl==""||furl==null) {return;}
      if(type!='jpg'&&type!='bmp'&&type!='gif'&&type!='png'){
       alert('��֧��jpg��bmp��gif��png��ʽ��ͼƬ');
       return;
      }
      imgform.form.submit({
       url : '/newsinfo.mvc/AddFiles_newsinfo',
       waitMsg : '�����ϴ�......',
       waitTitle : '��ȴ�',
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
         Ext.MessageBox.alert('����',
           '�ϴ�ʧ�ܣ���֧��jpg��bmp��gif��png��ʽ��ͼƬ');
       
       }
      
      });
     }
    }, {
     text : '�ر�',
     type : 'submit',
     handler : function() {
      win.close(this);
     }
    }]
   })

   var win = new Ext.Window({
      title : "�ϴ�ͼƬ",
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
  
},//�ϴ�ͼƬ����չ
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
       fieldLabel : 'ѡ���ļ�',
       name : 'userfile_F',
       id : 'userfile_F',
       inputType : 'file',
       allowBlank : false,
       blankText : '�ļ�����Ϊ��',
       height : 25,
       anchor : '98%'
      }],
    buttons : [{
     text : '�ϴ�',
     type : 'submit',
     handler : function() {
      var furl="";//�ļ������ַ
      var fname="";//�ļ�����
      furl=fileform.form.findField('userfile_F').getValue();
      var type=furl.substring(furl.length-3).toLowerCase();
      if (furl==""||furl==null) {return;}
      if(type!='doc'&&type!='xls'){
       alert('��֧���ϴ�doc��xls��ʽ���ļ�!');
       return;
      }
      fname=furl.substring(furl.lastIndexOf("\\")+1);
      fileform.form.submit({
       url : '/newsinfo.mvc/AddFiles_newsinfo',
       waitMsg : '�����ϴ�......',
       waitTitle : '��ȴ�',
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
       },
       failure : function() {
        form.reset();
        if (action.failureType == Ext.form.Action.SERVER_INVALID)
         Ext.MessageBox.alert('����',
           '�ϴ�ʧ�ܣ���֧���ϴ�doc��xls��ʽ���ļ�!');
       
       }
      
      });
     }
    }, {
     text : '�ر�',
     type : 'submit',
     handler : function() {
      winFile.close(this);
     }
    }]
   })

   var winFile = new Ext.Window({
      title : "�ϴ�����",
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
  
},//�ϴ���������չ
addflash : function() {
   var editor = this;
   var flashform = new Ext.FormPanel({
    region : 'center',
    labelWidth : 55,
    frame : true,
    bodyStyle : 'padding:5px 5px 0',
    autoScroll : true,
    border : false,
    items : [{
       xtype : 'textfield',
       fieldLabel : 'flash��ַ',
       name : 'userflash',
       id : 'userflash',
       allowBlank : false,
       blankText : 'http://',
       emptyText : 'http://',
       height : 25,
       anchor : '98%'
      }],
    buttons : [{
     text : '���',
     type : 'submit',
     handler : function() {
      var furl="";//�ļ������ַ
      furl=flashform.form.findField('userflash').getValue();
      var type=furl.substring(furl.length-3).toLowerCase();
      if (furl==""||furl==null) {return;}
      if(type!='swf'&&type!='flv'){
       alert('�Ƿ���ʽ�����飡');
       return;
      }
      var element = document.createElement("embed");
      element.src = furl;
      element.type="application/x-shockwave-flash";
      element.quality="high";
      element.style.width="300px";
      element.style.height="200px";
      if(Ext.isIE) {
       editor.insertAtCursor(element.outerHTML);
      } else {
        var selection = editor.win.getSelection();
        if (!selection.isCollapsed) {
            selection.deleteFromDocument();
        }
        selection.getRangeAt(0).insertNode(element);
      }
      winflash.close();
     }
    }, {
     text : '�ر�',
     type : 'submit',
     handler : function() {
      winflash.close(this);
     }
    }]
   })

   var winflash = new Ext.Window({
      title : "����flash",
      id : 'flashwin',
      width : 400,
      height : 120,
      modal : true,
      border : false,
      layout : "fit",
      iconCls : 'icon-swf',
      items : flashform

     });
   winflash.show();
  
},//����flash����չ
addfilm : function() {
   var editor = this;
   var filmform = new Ext.FormPanel({
    region : 'center',
    labelWidth : 70,
    frame : true,
    bodyStyle : 'padding:5px 5px 0',
    autoScroll : true,
    border : false,
    items : [{
       xtype : 'textfield',
       fieldLabel : '��ý���ַ',
       name : 'userfilm',
       id : 'userfilm',
       allowBlank : false,
       blankText : 'http://',
       emptyText : 'http://',
       height : 25,
       anchor : '98%'
      }],
    buttons : [{
     text : '���',
     type : 'submit',
     handler : function() {
      var furl="";//�ļ������ַ
      var regImg = new RegExp(/\.(mp3|wav|wma|wmv|avi|mpg|asf|rm|rmvb)$/);
      var regrm=new RegExp(/\.(rm|rmvb)$/);
      furl=filmform.form.findField('userfilm').getValue();
      //var type=furl.substring(furl.length-3).toLowerCase();
      if (furl==""||furl==null) {return;}
      if(!furl.match(regImg)){
       alert('�Ƿ���ʽ�����飡ϵͳ֧�֣�mp3,wav,wma,wmv,avi,mpg,asf,rm,rmvb');
       return;
      }
      var element = document.createElement("embed");
      element.src = furl;
      element.style.width="300px";
      element.style.height="200px";
      if(furl.match(regrm))
         element.type="audio/x-pn-realaudio-plugin";
      else
         element.type="video/x-ms-asf-plugin";
      element.loop="true";
      element.autostart="true";
      if(Ext.isIE) {
       editor.insertAtCursor(element.outerHTML);
      } else {
        var selection = editor.win.getSelection();
        if (!selection.isCollapsed) {
            selection.deleteFromDocument();
        }
        selection.getRangeAt(0).insertNode(element);
      }
      winfilm.close();
     }
    }, {
     text : '�ر�',
     type : 'submit',
     handler : function() {
      winfilm.close(this);
     }
    }]
   })

   var winfilm = new Ext.Window({
      title : "�����ý��",
      id : 'filmwin',
      width : 410,
      height : 120,
      modal : true,
      border : false,
      layout : "fit",
      iconCls : 'icon-film',
      items : filmform

     });
   winfilm.show();
  
},//�����ý�����չ
createToolbar : function(editor) {
   HTMLEditor.superclass.createToolbar.call(this, editor);
   this.tb.insertButton(16, {
      cls : "x-btn-icon",
      iconCls : "icon-uploadpic",
      handler : this.addImage,
      tooltip : "���ͼƬ",
      scope : this
     });
   this.tb.insertButton(17, {
      cls : "x-btn-icon",
      iconCls : 'icon-uploadfile',
      handler : this.addFile,
      tooltip : "����ļ�",
      scope : this
     });
     this.tb.insertButton(18, {
      cls : "x-btn-icon",
      iconCls : 'icon-swf',
      handler : this.addflash,
      tooltip : "���flash�ļ�",
      scope : this
     });
     this.tb.insertButton(19, {
      cls : "x-btn-icon",
      iconCls : 'icon-film',
      handler : this.addfilm,
      tooltip : "��Ӷ�ý���ļ�",
      scope : this
     });
  this.tb.insertButton(20, {//��������չ��������div
      cls : "x-btn-icon",
      iconCls : 'icon-div',
      handler : function() {
         var element = document.createElement("div");
         element.id="InsertDiv";
         element.style.backgroundColor="#FAFAFB";
         element.style.borderWidth="1px";
         element.style.borderStyle="solid";
         element.style.borderColor="#AECBE7";
         element.innerHTML="�ڴ˲������ݣ�<BR>";
         if(Ext.isIE) {
       editor.insertAtCursor(element.outerHTML);
      } else {
        var selection = editor.win.getSelection();
        if (!selection.isCollapsed) {
            selection.deleteFromDocument();
        }
        selection.getRangeAt(0).insertNode(element);
      }
      },
      tooltip : "���div��",
      scope : this
     });
     this.tb.insertButton(21, { //������ߵ���չ
      cls : "x-btn-icon",
      iconCls : 'icon-hr',
      handler :function() {
         var element = document.createElement("HR");
         if(Ext.isIE) {
       editor.insertAtCursor(element.outerHTML);
      } else {
        var selection = editor.win.getSelection();
        if (!selection.isCollapsed) {
            selection.deleteFromDocument();
        }
        selection.getRangeAt(0).insertNode(element);
      }
      },
      tooltip : "��Ӻ���",
      scope : this
     });
}
});
Ext.reg('CJ_starthtmleditor', HTMLEditor);

��ҿ��Ը����������������չ�Լ���Ҫ�Ķ�����

�����ϴ�ͼƬ�͸�����һ���������������£�

//�ϴ��ļ�
        [AcceptVerbs(HttpVerbs.Post)]
        public ActionResult AddFiles_newsinfo(FormCollection collection)
        {
            var rdto = new ResultDTO();
            var c = Request.Files[0];
            if (c != null && c.ContentLength > 0)
            {
                string filename = c.FileName;
                string destination = Server.MapPath("/UploadFile/");
                c.SaveAs(destination+ filename);
            }
            return null;
        }

