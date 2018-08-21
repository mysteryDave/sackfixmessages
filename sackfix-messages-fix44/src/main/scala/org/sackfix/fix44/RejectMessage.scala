package org.sackfix.fix44

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixMessageBody, SfFixMessageDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180821
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX44.xml
  */
case class RejectMessage(refSeqNumField:RefSeqNumField,
                         refTagIDField:Option[RefTagIDField]=None,
                         refMsgTypeField:Option[RefMsgTypeField]=None,
                         sessionRejectReasonField:Option[SessionRejectReasonField]=None,
                         textField:Option[TextField]=None,
                         encodedTextLenField:Option[EncodedTextLenField]=None,
                         encodedTextField:Option[EncodedTextField]=None) extends SfFixMessageBody("3")  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    fmt(b,refSeqNumField)
    refTagIDField.foreach(fmt(b,_))
    refMsgTypeField.foreach(fmt(b,_))
    sessionRejectReasonField.foreach(fmt(b,_))
    textField.foreach(fmt(b,_))
    encodedTextLenField.foreach(fmt(b,_))
    encodedTextField.foreach(fmt(b,_))
    b
  }

}
     
object RejectMessage extends SfFixMessageDecoder {
  val MsgType="3"
  val MsgName="Reject"
             
  override val MandatoryFields = HashSet[Int](
    RefSeqNumField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId) 
  }

  override val OptionalFields = HashSet[Int](
    RefTagIDField.TagId, RefMsgTypeField.TagId, SessionRejectReasonField.TagId, TextField.TagId, EncodedTextLenField.TagId, 
    EncodedTextField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId) 
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId) 

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==RefSeqNumField.TagId 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(RejectMessage(RefSeqNumField.decode(myFields.get(RefSeqNumField.TagId)).get,
        myFields.get(RefTagIDField.TagId).flatMap(f=>RefTagIDField.decode(f)),
        myFields.get(RefMsgTypeField.TagId).flatMap(f=>RefMsgTypeField.decode(f)),
        myFields.get(SessionRejectReasonField.TagId).flatMap(f=>SessionRejectReasonField.decode(f)),
        myFields.get(TextField.TagId).flatMap(f=>TextField.decode(f)),
        myFields.get(EncodedTextLenField.TagId).flatMap(f=>EncodedTextLenField.decode(f)),
        myFields.get(EncodedTextField.TagId).flatMap(f=>EncodedTextField.decode(f))))
    } else None
  }

    
}
     