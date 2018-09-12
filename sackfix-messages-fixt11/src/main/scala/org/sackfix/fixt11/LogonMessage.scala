package org.sackfix.fixt11

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixMessageBody, SfFixMessageDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180902
  * Source specification was read from:
  *   /quickfixj1.6.0/FIXT11.xml
  */
case class LogonMessage(encryptMethodField:EncryptMethodField,
                        heartBtIntField:HeartBtIntField,
                        rawDataLengthField:Option[RawDataLengthField]=None,
                        rawDataField:Option[RawDataField]=None,
                        resetSeqNumFlagField:Option[ResetSeqNumFlagField]=None,
                        nextExpectedMsgSeqNumField:Option[NextExpectedMsgSeqNumField]=None,
                        maxMessageSizeField:Option[MaxMessageSizeField]=None,
                        msgTypeGrpComponent:Option[MsgTypeGrpComponent]=None,
                        testMessageIndicatorField:Option[TestMessageIndicatorField]=None,
                        usernameField:Option[UsernameField]=None,
                        passwordField:Option[PasswordField]=None,
                        newPasswordField:Option[NewPasswordField]=None,
                        encryptedPasswordMethodField:Option[EncryptedPasswordMethodField]=None,
                        encryptedPasswordLenField:Option[EncryptedPasswordLenField]=None,
                        encryptedPasswordField:Option[EncryptedPasswordField]=None,
                        encryptedNewPasswordLenField:Option[EncryptedNewPasswordLenField]=None,
                        encryptedNewPasswordField:Option[EncryptedNewPasswordField]=None,
                        sessionStatusField:Option[SessionStatusField]=None,
                        defaultApplVerIDField:DefaultApplVerIDField,
                        defaultApplExtIDField:Option[DefaultApplExtIDField]=None,
                        defaultCstmApplVerIDField:Option[DefaultCstmApplVerIDField]=None,
                        textField:Option[TextField]=None,
                        encodedTextLenField:Option[EncodedTextLenField]=None,
                        encodedTextField:Option[EncodedTextField]=None) extends SfFixMessageBody("A")  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    fmt(b,encryptMethodField)
    fmt(b,heartBtIntField)
    rawDataLengthField.foreach(fmt(b,_))
    rawDataField.foreach(fmt(b,_))
    resetSeqNumFlagField.foreach(fmt(b,_))
    nextExpectedMsgSeqNumField.foreach(fmt(b,_))
    maxMessageSizeField.foreach(fmt(b,_))
    msgTypeGrpComponent.foreach(fmt(b,_))
    testMessageIndicatorField.foreach(fmt(b,_))
    usernameField.foreach(fmt(b,_))
    passwordField.foreach(fmt(b,_))
    newPasswordField.foreach(fmt(b,_))
    encryptedPasswordMethodField.foreach(fmt(b,_))
    encryptedPasswordLenField.foreach(fmt(b,_))
    encryptedPasswordField.foreach(fmt(b,_))
    encryptedNewPasswordLenField.foreach(fmt(b,_))
    encryptedNewPasswordField.foreach(fmt(b,_))
    sessionStatusField.foreach(fmt(b,_))
    fmt(b,defaultApplVerIDField)
    defaultApplExtIDField.foreach(fmt(b,_))
    defaultCstmApplVerIDField.foreach(fmt(b,_))
    textField.foreach(fmt(b,_))
    encodedTextLenField.foreach(fmt(b,_))
    encodedTextField.foreach(fmt(b,_))
    b
  }

}
     
object LogonMessage extends SfFixMessageDecoder {
  val MsgType="A"
  val MsgName="Logon"
             
  override val MandatoryFields = HashSet[Int](
    EncryptMethodField.TagId, HeartBtIntField.TagId, DefaultApplVerIDField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    MsgTypeGrpComponent.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    RawDataLengthField.TagId, RawDataField.TagId, ResetSeqNumFlagField.TagId, NextExpectedMsgSeqNumField.TagId, MaxMessageSizeField.TagId, 
    TestMessageIndicatorField.TagId, UsernameField.TagId, PasswordField.TagId, NewPasswordField.TagId, EncryptedPasswordMethodField.TagId, 
    EncryptedPasswordLenField.TagId, EncryptedPasswordField.TagId, EncryptedNewPasswordLenField.TagId, EncryptedNewPasswordField.TagId, SessionStatusField.TagId, 
    DefaultApplExtIDField.TagId, DefaultCstmApplVerIDField.TagId, TextField.TagId, EncodedTextLenField.TagId, EncodedTextField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    MsgTypeGrpComponent.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    MsgTypeGrpComponent.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==EncryptMethodField.TagId 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(LogonMessage(EncryptMethodField.decode(myFields.get(EncryptMethodField.TagId)).get,
        HeartBtIntField.decode(myFields.get(HeartBtIntField.TagId)).get,
        myFields.get(RawDataLengthField.TagId).flatMap(f=>RawDataLengthField.decode(f)),
        myFields.get(RawDataField.TagId).flatMap(f=>RawDataField.decode(f)),
        myFields.get(ResetSeqNumFlagField.TagId).flatMap(f=>ResetSeqNumFlagField.decode(f)),
        myFields.get(NextExpectedMsgSeqNumField.TagId).flatMap(f=>NextExpectedMsgSeqNumField.decode(f)),
        myFields.get(MaxMessageSizeField.TagId).flatMap(f=>MaxMessageSizeField.decode(f)),
        MsgTypeGrpComponent.decode(flds, startPos),
        myFields.get(TestMessageIndicatorField.TagId).flatMap(f=>TestMessageIndicatorField.decode(f)),
        myFields.get(UsernameField.TagId).flatMap(f=>UsernameField.decode(f)),
        myFields.get(PasswordField.TagId).flatMap(f=>PasswordField.decode(f)),
        myFields.get(NewPasswordField.TagId).flatMap(f=>NewPasswordField.decode(f)),
        myFields.get(EncryptedPasswordMethodField.TagId).flatMap(f=>EncryptedPasswordMethodField.decode(f)),
        myFields.get(EncryptedPasswordLenField.TagId).flatMap(f=>EncryptedPasswordLenField.decode(f)),
        myFields.get(EncryptedPasswordField.TagId).flatMap(f=>EncryptedPasswordField.decode(f)),
        myFields.get(EncryptedNewPasswordLenField.TagId).flatMap(f=>EncryptedNewPasswordLenField.decode(f)),
        myFields.get(EncryptedNewPasswordField.TagId).flatMap(f=>EncryptedNewPasswordField.decode(f)),
        myFields.get(SessionStatusField.TagId).flatMap(f=>SessionStatusField.decode(f)),
        DefaultApplVerIDField.decode(myFields.get(DefaultApplVerIDField.TagId)).get,
        myFields.get(DefaultApplExtIDField.TagId).flatMap(f=>DefaultApplExtIDField.decode(f)),
        myFields.get(DefaultCstmApplVerIDField.TagId).flatMap(f=>DefaultCstmApplVerIDField.decode(f)),
        myFields.get(TextField.TagId).flatMap(f=>TextField.decode(f)),
        myFields.get(EncodedTextLenField.TagId).flatMap(f=>EncodedTextLenField.decode(f)),
        myFields.get(EncodedTextField.TagId).flatMap(f=>EncodedTextField.decode(f))))
    } else None
  }

    
}
     