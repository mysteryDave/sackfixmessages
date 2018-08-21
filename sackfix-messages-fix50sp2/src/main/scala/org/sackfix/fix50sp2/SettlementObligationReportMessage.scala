package org.sackfix.fix50sp2

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixMessageBody, SfFixMessageDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180821
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP2.xml
  */
case class SettlementObligationReportMessage(applicationSequenceControlComponent:Option[ApplicationSequenceControlComponent]=None,
                                             clearingBusinessDateField:Option[ClearingBusinessDateField]=None,
                                             settlementCycleNoField:Option[SettlementCycleNoField]=None,
                                             settlObligMsgIDField:SettlObligMsgIDField,
                                             settlObligModeField:SettlObligModeField,
                                             textField:Option[TextField]=None,
                                             encodedTextLenField:Option[EncodedTextLenField]=None,
                                             encodedTextField:Option[EncodedTextField]=None,
                                             transactTimeField:Option[TransactTimeField]=None,
                                             settlObligationInstructionsComponent:SettlObligationInstructionsComponent) extends SfFixMessageBody("BQ")  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    applicationSequenceControlComponent.foreach(fmt(b,_))
    clearingBusinessDateField.foreach(fmt(b,_))
    settlementCycleNoField.foreach(fmt(b,_))
    fmt(b,settlObligMsgIDField)
    fmt(b,settlObligModeField)
    textField.foreach(fmt(b,_))
    encodedTextLenField.foreach(fmt(b,_))
    encodedTextField.foreach(fmt(b,_))
    transactTimeField.foreach(fmt(b,_))
    fmt(b,settlObligationInstructionsComponent)
    b
  }

}
     
object SettlementObligationReportMessage extends SfFixMessageDecoder {
  val MsgType="BQ"
  val MsgName="SettlementObligationReport"
             
  override val MandatoryFields = HashSet[Int](
    SettlObligMsgIDField.TagId, SettlObligModeField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    ApplicationSequenceControlComponent.isMandatoryField(tagId) || SettlObligationInstructionsComponent.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    ClearingBusinessDateField.TagId, SettlementCycleNoField.TagId, TextField.TagId, EncodedTextLenField.TagId, EncodedTextField.TagId, 
    TransactTimeField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    ApplicationSequenceControlComponent.isOptionalField(tagId) || SettlObligationInstructionsComponent.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    ApplicationSequenceControlComponent.isFieldOf(tagId) || SettlObligationInstructionsComponent.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = ApplicationSequenceControlComponent.isFirstField(tagId) 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(SettlementObligationReportMessage(ApplicationSequenceControlComponent.decode(flds, startPos),
        myFields.get(ClearingBusinessDateField.TagId).flatMap(f=>ClearingBusinessDateField.decode(f)),
        myFields.get(SettlementCycleNoField.TagId).flatMap(f=>SettlementCycleNoField.decode(f)),
        SettlObligMsgIDField.decode(myFields.get(SettlObligMsgIDField.TagId)).get,
        SettlObligModeField.decode(myFields.get(SettlObligModeField.TagId)).get,
        myFields.get(TextField.TagId).flatMap(f=>TextField.decode(f)),
        myFields.get(EncodedTextLenField.TagId).flatMap(f=>EncodedTextLenField.decode(f)),
        myFields.get(EncodedTextField.TagId).flatMap(f=>EncodedTextField.decode(f)),
        myFields.get(TransactTimeField.TagId).flatMap(f=>TransactTimeField.decode(f)),
        SettlObligationInstructionsComponent.decode(flds, startPos).get))
    } else None
  }

    
}
     