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
case class AssignmentReportMessage(applicationSequenceControlComponent:Option[ApplicationSequenceControlComponent]=None,
                                   asgnRptIDField:AsgnRptIDField,
                                   posReqIDField:Option[PosReqIDField]=None,
                                   totNumAssignmentReportsField:Option[TotNumAssignmentReportsField]=None,
                                   lastRptRequestedField:Option[LastRptRequestedField]=None,
                                   partiesComponent:PartiesComponent,
                                   accountField:Option[AccountField]=None,
                                   accountTypeField:Option[AccountTypeField]=None,
                                   instrumentComponent:Option[InstrumentComponent]=None,
                                   currencyField:Option[CurrencyField]=None,
                                   instrmtLegGrpComponent:Option[InstrmtLegGrpComponent]=None,
                                   undInstrmtGrpComponent:Option[UndInstrmtGrpComponent]=None,
                                   positionQtyComponent:Option[PositionQtyComponent]=None,
                                   positionAmountDataComponent:Option[PositionAmountDataComponent]=None,
                                   thresholdAmountField:Option[ThresholdAmountField]=None,
                                   settlPriceField:Option[SettlPriceField]=None,
                                   settlPriceTypeField:Option[SettlPriceTypeField]=None,
                                   underlyingSettlPriceField:Option[UnderlyingSettlPriceField]=None,
                                   priorSettlPriceField:Option[PriorSettlPriceField]=None,
                                   expireDateField:Option[ExpireDateField]=None,
                                   assignmentMethodField:Option[AssignmentMethodField]=None,
                                   assignmentUnitField:Option[AssignmentUnitField]=None,
                                   openInterestField:Option[OpenInterestField]=None,
                                   exerciseMethodField:Option[ExerciseMethodField]=None,
                                   settlSessIDField:Option[SettlSessIDField]=None,
                                   settlSessSubIDField:Option[SettlSessSubIDField]=None,
                                   clearingBusinessDateField:ClearingBusinessDateField,
                                   textField:Option[TextField]=None,
                                   encodedTextLenField:Option[EncodedTextLenField]=None,
                                   encodedTextField:Option[EncodedTextField]=None) extends SfFixMessageBody("AW")  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    applicationSequenceControlComponent.foreach(fmt(b,_))
    fmt(b,asgnRptIDField)
    posReqIDField.foreach(fmt(b,_))
    totNumAssignmentReportsField.foreach(fmt(b,_))
    lastRptRequestedField.foreach(fmt(b,_))
    fmt(b,partiesComponent)
    accountField.foreach(fmt(b,_))
    accountTypeField.foreach(fmt(b,_))
    instrumentComponent.foreach(fmt(b,_))
    currencyField.foreach(fmt(b,_))
    instrmtLegGrpComponent.foreach(fmt(b,_))
    undInstrmtGrpComponent.foreach(fmt(b,_))
    positionQtyComponent.foreach(fmt(b,_))
    positionAmountDataComponent.foreach(fmt(b,_))
    thresholdAmountField.foreach(fmt(b,_))
    settlPriceField.foreach(fmt(b,_))
    settlPriceTypeField.foreach(fmt(b,_))
    underlyingSettlPriceField.foreach(fmt(b,_))
    priorSettlPriceField.foreach(fmt(b,_))
    expireDateField.foreach(fmt(b,_))
    assignmentMethodField.foreach(fmt(b,_))
    assignmentUnitField.foreach(fmt(b,_))
    openInterestField.foreach(fmt(b,_))
    exerciseMethodField.foreach(fmt(b,_))
    settlSessIDField.foreach(fmt(b,_))
    settlSessSubIDField.foreach(fmt(b,_))
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
    AsgnRptIDField.TagId, ClearingBusinessDateField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    ApplicationSequenceControlComponent.isMandatoryField(tagId) || PartiesComponent.isMandatoryField(tagId) || InstrumentComponent.isMandatoryField(tagId) || InstrmtLegGrpComponent.isMandatoryField(tagId) || 
    UndInstrmtGrpComponent.isMandatoryField(tagId) || PositionQtyComponent.isMandatoryField(tagId) || PositionAmountDataComponent.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    PosReqIDField.TagId, TotNumAssignmentReportsField.TagId, LastRptRequestedField.TagId, AccountField.TagId, AccountTypeField.TagId, 
    CurrencyField.TagId, ThresholdAmountField.TagId, SettlPriceField.TagId, SettlPriceTypeField.TagId, UnderlyingSettlPriceField.TagId, 
    PriorSettlPriceField.TagId, ExpireDateField.TagId, AssignmentMethodField.TagId, AssignmentUnitField.TagId, OpenInterestField.TagId, 
    ExerciseMethodField.TagId, SettlSessIDField.TagId, SettlSessSubIDField.TagId, TextField.TagId, EncodedTextLenField.TagId, 
    EncodedTextField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    ApplicationSequenceControlComponent.isOptionalField(tagId) || PartiesComponent.isOptionalField(tagId) || InstrumentComponent.isOptionalField(tagId) || InstrmtLegGrpComponent.isOptionalField(tagId) || 
    UndInstrmtGrpComponent.isOptionalField(tagId) || PositionQtyComponent.isOptionalField(tagId) || PositionAmountDataComponent.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    ApplicationSequenceControlComponent.isFieldOf(tagId) || PartiesComponent.isFieldOf(tagId) || InstrumentComponent.isFieldOf(tagId) || 
    InstrmtLegGrpComponent.isFieldOf(tagId) || UndInstrmtGrpComponent.isFieldOf(tagId) || PositionQtyComponent.isFieldOf(tagId) || 
    PositionAmountDataComponent.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = ApplicationSequenceControlComponent.isFirstField(tagId) 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(AssignmentReportMessage(ApplicationSequenceControlComponent.decode(flds, startPos),
        AsgnRptIDField.decode(myFields.get(AsgnRptIDField.TagId)).get,
        myFields.get(PosReqIDField.TagId).flatMap(f=>PosReqIDField.decode(f)),
        myFields.get(TotNumAssignmentReportsField.TagId).flatMap(f=>TotNumAssignmentReportsField.decode(f)),
        myFields.get(LastRptRequestedField.TagId).flatMap(f=>LastRptRequestedField.decode(f)),
        PartiesComponent.decode(flds, startPos).get,
        myFields.get(AccountField.TagId).flatMap(f=>AccountField.decode(f)),
        myFields.get(AccountTypeField.TagId).flatMap(f=>AccountTypeField.decode(f)),
        InstrumentComponent.decode(flds, startPos),
        myFields.get(CurrencyField.TagId).flatMap(f=>CurrencyField.decode(f)),
        InstrmtLegGrpComponent.decode(flds, startPos),
        UndInstrmtGrpComponent.decode(flds, startPos),
        PositionQtyComponent.decode(flds, startPos),
        PositionAmountDataComponent.decode(flds, startPos),
        myFields.get(ThresholdAmountField.TagId).flatMap(f=>ThresholdAmountField.decode(f)),
        myFields.get(SettlPriceField.TagId).flatMap(f=>SettlPriceField.decode(f)),
        myFields.get(SettlPriceTypeField.TagId).flatMap(f=>SettlPriceTypeField.decode(f)),
        myFields.get(UnderlyingSettlPriceField.TagId).flatMap(f=>UnderlyingSettlPriceField.decode(f)),
        myFields.get(PriorSettlPriceField.TagId).flatMap(f=>PriorSettlPriceField.decode(f)),
        myFields.get(ExpireDateField.TagId).flatMap(f=>ExpireDateField.decode(f)),
        myFields.get(AssignmentMethodField.TagId).flatMap(f=>AssignmentMethodField.decode(f)),
        myFields.get(AssignmentUnitField.TagId).flatMap(f=>AssignmentUnitField.decode(f)),
        myFields.get(OpenInterestField.TagId).flatMap(f=>OpenInterestField.decode(f)),
        myFields.get(ExerciseMethodField.TagId).flatMap(f=>ExerciseMethodField.decode(f)),
        myFields.get(SettlSessIDField.TagId).flatMap(f=>SettlSessIDField.decode(f)),
        myFields.get(SettlSessSubIDField.TagId).flatMap(f=>SettlSessSubIDField.decode(f)),
        ClearingBusinessDateField.decode(myFields.get(ClearingBusinessDateField.TagId)).get,
        myFields.get(TextField.TagId).flatMap(f=>TextField.decode(f)),
        myFields.get(EncodedTextLenField.TagId).flatMap(f=>EncodedTextLenField.decode(f)),
        myFields.get(EncodedTextField.TagId).flatMap(f=>EncodedTextField.decode(f))))
    } else None
  }

    
}
     