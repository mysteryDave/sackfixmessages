package org.sackfix.fix50

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixMessageBody, SfFixMessageDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180902
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50.xml
  */
case class ContraryIntentionReportMessage(contIntRptIDField:ContIntRptIDField,
                                          transactTimeField:Option[TransactTimeField]=None,
                                          lateIndicatorField:Option[LateIndicatorField]=None,
                                          inputSourceField:Option[InputSourceField]=None,
                                          clearingBusinessDateField:ClearingBusinessDateField,
                                          partiesComponent:PartiesComponent,
                                          expirationQtyComponent:ExpirationQtyComponent,
                                          instrumentComponent:InstrumentComponent,
                                          textField:Option[TextField]=None,
                                          encodedTextLenField:Option[EncodedTextLenField]=None,
                                          encodedTextField:Option[EncodedTextField]=None,
                                          undInstrmtGrpComponent:Option[UndInstrmtGrpComponent]=None) extends SfFixMessageBody("BO")  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    fmt(b,contIntRptIDField)
    transactTimeField.foreach(fmt(b,_))
    lateIndicatorField.foreach(fmt(b,_))
    inputSourceField.foreach(fmt(b,_))
    fmt(b,clearingBusinessDateField)
    fmt(b,partiesComponent)
    fmt(b,expirationQtyComponent)
    fmt(b,instrumentComponent)
    textField.foreach(fmt(b,_))
    encodedTextLenField.foreach(fmt(b,_))
    encodedTextField.foreach(fmt(b,_))
    undInstrmtGrpComponent.foreach(fmt(b,_))
    b
  }

}
     
object ContraryIntentionReportMessage extends SfFixMessageDecoder {
  val MsgType="BO"
  val MsgName="ContraryIntentionReport"
             
  override val MandatoryFields = HashSet[Int](
    ContIntRptIDField.TagId, ClearingBusinessDateField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    PartiesComponent.isMandatoryField(tagId) || ExpirationQtyComponent.isMandatoryField(tagId) || InstrumentComponent.isMandatoryField(tagId) || UndInstrmtGrpComponent.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    TransactTimeField.TagId, LateIndicatorField.TagId, InputSourceField.TagId, TextField.TagId, EncodedTextLenField.TagId, 
    EncodedTextField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    PartiesComponent.isOptionalField(tagId) || ExpirationQtyComponent.isOptionalField(tagId) || InstrumentComponent.isOptionalField(tagId) || UndInstrmtGrpComponent.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    PartiesComponent.isFieldOf(tagId) || ExpirationQtyComponent.isFieldOf(tagId) || InstrumentComponent.isFieldOf(tagId) || 
    UndInstrmtGrpComponent.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==ContIntRptIDField.TagId 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(ContraryIntentionReportMessage(ContIntRptIDField.decode(myFields.get(ContIntRptIDField.TagId)).get,
        myFields.get(TransactTimeField.TagId).flatMap(f=>TransactTimeField.decode(f)),
        myFields.get(LateIndicatorField.TagId).flatMap(f=>LateIndicatorField.decode(f)),
        myFields.get(InputSourceField.TagId).flatMap(f=>InputSourceField.decode(f)),
        ClearingBusinessDateField.decode(myFields.get(ClearingBusinessDateField.TagId)).get,
        PartiesComponent.decode(flds, startPos).get,
        ExpirationQtyComponent.decode(flds, startPos).get,
        InstrumentComponent.decode(flds, startPos).get,
        myFields.get(TextField.TagId).flatMap(f=>TextField.decode(f)),
        myFields.get(EncodedTextLenField.TagId).flatMap(f=>EncodedTextLenField.decode(f)),
        myFields.get(EncodedTextField.TagId).flatMap(f=>EncodedTextField.decode(f)),
        UndInstrmtGrpComponent.decode(flds, startPos)))
    } else None
  }

    
}
     