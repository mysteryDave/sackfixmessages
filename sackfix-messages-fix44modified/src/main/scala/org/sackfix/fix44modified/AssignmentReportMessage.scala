package org.sackfix.fix44modified

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixMessageBody, SfFixMessageDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180821
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX44.modified.xml
  */
case class AssignmentReportMessage(asgnRptIDField:AsgnRptIDField,
                                   totNumAssignmentReportsField:Option[TotNumAssignmentReportsField]=None,
                                   lastRptRequestedField:Option[LastRptRequestedField]=None,
                                   partiesComponent:PartiesComponent,
                                   accountField:Option[AccountField]=None,
                                   accountTypeField:AccountTypeField,
                                   instrumentComponent:Option[InstrumentComponent]=None,
                                   currencyField:Option[CurrencyField]=None,
                                   noLegsField:Option[NoLegsField]=None,
                                   instrumentLegComponent:Option[InstrumentLegComponent]=None,
                                   noUnderlyingsField:Option[NoUnderlyingsField]=None,
                                   underlyingsGroups: Option[List[UnderlyingsGroup]]=None,
                                   positionQtyComponent:PositionQtyComponent,
                                   positionAmountDataComponent:PositionAmountDataComponent,
                                   thresholdAmountField:Option[ThresholdAmountField]=None,
                                   settlPriceField:SettlPriceField,
                                   settlPriceTypeField:SettlPriceTypeField,
                                   underlyingSettlPriceField:UnderlyingSettlPriceField,
                                   expireDateField:Option[ExpireDateField]=None,
                                   assignmentMethodField:AssignmentMethodField,
                                   assignmentUnitField:Option[AssignmentUnitField]=None,
                                   openInterestField:OpenInterestField,
                                   exerciseMethodField:ExerciseMethodField,
                                   settlSessIDField:SettlSessIDField,
                                   settlSessSubIDField:SettlSessSubIDField,
                                   clearingBusinessDateField:ClearingBusinessDateField,
                                   textField:Option[TextField]=None,
                                   encodedTextLenField:Option[EncodedTextLenField]=None,
                                   encodedTextField:Option[EncodedTextField]=None) extends SfFixMessageBody("AW")  with SfFixRenderable with SfFixFieldsToAscii {
  if (noUnderlyingsField.map(_.value).getOrElse(0) != underlyingsGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoUnderlyingsField.TagId,noUnderlyingsField.map(_.value).getOrElse(0), underlyingsGroups.map(_.size).getOrElse(0))

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    fmt(b,asgnRptIDField)
    totNumAssignmentReportsField.foreach(fmt(b,_))
    lastRptRequestedField.foreach(fmt(b,_))
    fmt(b,partiesComponent)
    accountField.foreach(fmt(b,_))
    fmt(b,accountTypeField)
    instrumentComponent.foreach(fmt(b,_))
    currencyField.foreach(fmt(b,_))
    noLegsField.foreach(fmt(b,_))
    instrumentLegComponent.foreach(fmt(b,_))
    noUnderlyingsField.foreach(fmt(b,_))
    underlyingsGroups.getOrElse(List.empty).foreach(fmt(b,_))
    fmt(b,positionQtyComponent)
    fmt(b,positionAmountDataComponent)
    thresholdAmountField.foreach(fmt(b,_))
    fmt(b,settlPriceField)
    fmt(b,settlPriceTypeField)
    fmt(b,underlyingSettlPriceField)
    expireDateField.foreach(fmt(b,_))
    fmt(b,assignmentMethodField)
    assignmentUnitField.foreach(fmt(b,_))
    fmt(b,openInterestField)
    fmt(b,exerciseMethodField)
    fmt(b,settlSessIDField)
    fmt(b,settlSessSubIDField)
    fmt(b,clearingBusinessDateField)
    textField.foreach(fmt(b,_))
    encodedTextLenField.foreach(fmt(b,_))
    encodedTextField.foreach(fmt(b,_))
    b
  }

}
     
object AssignmentReportMessage extends SfFixMessageDecoder {
  val MsgType="AW"
  val MsgName="AssignmentReport"
             
  override val MandatoryFields = HashSet[Int](
    AsgnRptIDField.TagId, AccountTypeField.TagId, SettlPriceField.TagId, SettlPriceTypeField.TagId, UnderlyingSettlPriceField.TagId, 
    AssignmentMethodField.TagId, OpenInterestField.TagId, ExerciseMethodField.TagId, SettlSessIDField.TagId, SettlSessSubIDField.TagId, 
    ClearingBusinessDateField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    PartiesComponent.isMandatoryField(tagId) || InstrumentComponent.isMandatoryField(tagId) || InstrumentLegComponent.isMandatoryField(tagId) || UnderlyingsGroup.isMandatoryField(tagId) || 
    PositionQtyComponent.isMandatoryField(tagId) || PositionAmountDataComponent.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    TotNumAssignmentReportsField.TagId, LastRptRequestedField.TagId, AccountField.TagId, CurrencyField.TagId, NoLegsField.TagId, 
    NoUnderlyingsField.TagId, ThresholdAmountField.TagId, ExpireDateField.TagId, AssignmentUnitField.TagId, TextField.TagId, 
    EncodedTextLenField.TagId, EncodedTextField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    PartiesComponent.isOptionalField(tagId) || InstrumentComponent.isOptionalField(tagId) || InstrumentLegComponent.isOptionalField(tagId) || UnderlyingsGroup.isOptionalField(tagId) || 
    PositionQtyComponent.isOptionalField(tagId) || PositionAmountDataComponent.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    PartiesComponent.isFieldOf(tagId) || InstrumentComponent.isFieldOf(tagId) || InstrumentLegComponent.isFieldOf(tagId) || 
    UnderlyingsGroup.isFieldOf(tagId) || PositionQtyComponent.isFieldOf(tagId) || PositionAmountDataComponent.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoUnderlyingsField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==AsgnRptIDField.TagId 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(AssignmentReportMessage(AsgnRptIDField.decode(myFields.get(AsgnRptIDField.TagId)).get,
        myFields.get(TotNumAssignmentReportsField.TagId).flatMap(f=>TotNumAssignmentReportsField.decode(f)),
        myFields.get(LastRptRequestedField.TagId).flatMap(f=>LastRptRequestedField.decode(f)),
        PartiesComponent.decode(flds, startPos).get,
        myFields.get(AccountField.TagId).flatMap(f=>AccountField.decode(f)),
        AccountTypeField.decode(myFields.get(AccountTypeField.TagId)).get,
        InstrumentComponent.decode(flds, startPos),
        myFields.get(CurrencyField.TagId).flatMap(f=>CurrencyField.decode(f)),
        myFields.get(NoLegsField.TagId).flatMap(f=>NoLegsField.decode(f)),
        InstrumentLegComponent.decode(flds, startPos),
        myFields.get(NoUnderlyingsField.TagId).flatMap(f=>NoUnderlyingsField.decode(f)),
        if (nextTagPosLookup.contains(NoUnderlyingsField.TagId)) UnderlyingsGroup.decode(flds, nextTagPosLookup(NoUnderlyingsField.TagId)) else None,
        PositionQtyComponent.decode(flds, startPos).get,
        PositionAmountDataComponent.decode(flds, startPos).get,
        myFields.get(ThresholdAmountField.TagId).flatMap(f=>ThresholdAmountField.decode(f)),
        SettlPriceField.decode(myFields.get(SettlPriceField.TagId)).get,
        SettlPriceTypeField.decode(myFields.get(SettlPriceTypeField.TagId)).get,
        UnderlyingSettlPriceField.decode(myFields.get(UnderlyingSettlPriceField.TagId)).get,
        myFields.get(ExpireDateField.TagId).flatMap(f=>ExpireDateField.decode(f)),
        AssignmentMethodField.decode(myFields.get(AssignmentMethodField.TagId)).get,
        myFields.get(AssignmentUnitField.TagId).flatMap(f=>AssignmentUnitField.decode(f)),
        OpenInterestField.decode(myFields.get(OpenInterestField.TagId)).get,
        ExerciseMethodField.decode(myFields.get(ExerciseMethodField.TagId)).get,
        SettlSessIDField.decode(myFields.get(SettlSessIDField.TagId)).get,
        SettlSessSubIDField.decode(myFields.get(SettlSessSubIDField.TagId)).get,
        ClearingBusinessDateField.decode(myFields.get(ClearingBusinessDateField.TagId)).get,
        myFields.get(TextField.TagId).flatMap(f=>TextField.decode(f)),
        myFields.get(EncodedTextLenField.TagId).flatMap(f=>EncodedTextLenField.decode(f)),
        myFields.get(EncodedTextField.TagId).flatMap(f=>EncodedTextField.decode(f))))
    } else None
  }

    
}
     