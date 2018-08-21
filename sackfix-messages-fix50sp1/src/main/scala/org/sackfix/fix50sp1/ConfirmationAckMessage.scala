package org.sackfix.fix50sp1

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixMessageBody, SfFixMessageDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180821
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP1.xml
  */
case class ConfirmationAckMessage(confirmIDField:ConfirmIDField,
                                  tradeDateField:TradeDateField,
                                  transactTimeField:TransactTimeField,
                                  affirmStatusField:AffirmStatusField,
                                  confirmRejReasonField:Option[ConfirmRejReasonField]=None,
                                  matchStatusField:Option[MatchStatusField]=None,
                                  textField:Option[TextField]=None,
                                  encodedTextLenField:Option[EncodedTextLenField]=None,
                                  encodedTextField:Option[EncodedTextField]=None) extends SfFixMessageBody("AU")  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    fmt(b,confirmIDField)
    fmt(b,tradeDateField)
    fmt(b,transactTimeField)
    fmt(b,affirmStatusField)
    confirmRejReasonField.foreach(fmt(b,_))
    matchStatusField.foreach(fmt(b,_))
    textField.foreach(fmt(b,_))
    encodedTextLenField.foreach(fmt(b,_))
    encodedTextField.foreach(fmt(b,_))
    b
  }

}
     
object ConfirmationAckMessage extends SfFixMessageDecoder {
  val MsgType="AU"
  val MsgName="ConfirmationAck"
             
  override val MandatoryFields = HashSet[Int](
    ConfirmIDField.TagId, TradeDateField.TagId, TransactTimeField.TagId, AffirmStatusField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId) 
  }

  override val OptionalFields = HashSet[Int](
    ConfirmRejReasonField.TagId, MatchStatusField.TagId, TextField.TagId, EncodedTextLenField.TagId, EncodedTextField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId) 
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId) 

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==ConfirmIDField.TagId 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(ConfirmationAckMessage(ConfirmIDField.decode(myFields.get(ConfirmIDField.TagId)).get,
        TradeDateField.decode(myFields.get(TradeDateField.TagId)).get,
        TransactTimeField.decode(myFields.get(TransactTimeField.TagId)).get,
        AffirmStatusField.decode(myFields.get(AffirmStatusField.TagId)).get,
        myFields.get(ConfirmRejReasonField.TagId).flatMap(f=>ConfirmRejReasonField.decode(f)),
        myFields.get(MatchStatusField.TagId).flatMap(f=>MatchStatusField.decode(f)),
        myFields.get(TextField.TagId).flatMap(f=>TextField.decode(f)),
        myFields.get(EncodedTextLenField.TagId).flatMap(f=>EncodedTextLenField.decode(f)),
        myFields.get(EncodedTextField.TagId).flatMap(f=>EncodedTextField.decode(f))))
    } else None
  }

    
}
     