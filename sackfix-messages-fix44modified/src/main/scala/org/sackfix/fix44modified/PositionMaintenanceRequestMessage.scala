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
case class PositionMaintenanceRequestMessage(posReqIDField:PosReqIDField,
                                             posTransTypeField:PosTransTypeField,
                                             posMaintActionField:PosMaintActionField,
                                             origPosReqRefIDField:Option[OrigPosReqRefIDField]=None,
                                             posMaintRptRefIDField:Option[PosMaintRptRefIDField]=None,
                                             clearingBusinessDateField:ClearingBusinessDateField,
                                             settlSessIDField:Option[SettlSessIDField]=None,
                                             settlSessSubIDField:Option[SettlSessSubIDField]=None,
                                             partiesComponent:PartiesComponent,
                                             accountField:AccountField,
                                             acctIDSourceField:Option[AcctIDSourceField]=None,
                                             accountTypeField:AccountTypeField,
                                             instrumentComponent:InstrumentComponent,
                                             currencyField:Option[CurrencyField]=None,
                                             noLegsField:Option[NoLegsField]=None,
                                             legsGroups: Option[List[LegsGroup]]=None,
                                             noUnderlyingsField:Option[NoUnderlyingsField]=None,
                                             underlyingsGroups: Option[List[UnderlyingsGroup]]=None,
                                             noTradingSessionsField:Option[NoTradingSessionsField]=None,
                                             tradingSessionsGroups: Option[List[TradingSessionsGroup]]=None,
                                             transactTimeField:TransactTimeField,
                                             positionQtyComponent:PositionQtyComponent,
                                             adjustmentTypeField:Option[AdjustmentTypeField]=None,
                                             contraryInstructionIndicatorField:Option[ContraryInstructionIndicatorField]=None,
                                             priorSpreadIndicatorField:Option[PriorSpreadIndicatorField]=None,
                                             thresholdAmountField:Option[ThresholdAmountField]=None,
                                             textField:Option[TextField]=None,
                                             encodedTextLenField:Option[EncodedTextLenField]=None,
                                             encodedTextField:Option[EncodedTextField]=None) extends SfFixMessageBody("AL")  with SfFixRenderable with SfFixFieldsToAscii {
  if (noLegsField.map(_.value).getOrElse(0) != legsGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoLegsField.TagId,noLegsField.map(_.value).getOrElse(0), legsGroups.map(_.size).getOrElse(0))
  if (noUnderlyingsField.map(_.value).getOrElse(0) != underlyingsGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoUnderlyingsField.TagId,noUnderlyingsField.map(_.value).getOrElse(0), underlyingsGroups.map(_.size).getOrElse(0))
  if (noTradingSessionsField.map(_.value).getOrElse(0) != tradingSessionsGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoTradingSessionsField.TagId,noTradingSessionsField.map(_.value).getOrElse(0), tradingSessionsGroups.map(_.size).getOrElse(0))

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    fmt(b,posReqIDField)
    fmt(b,posTransTypeField)
    fmt(b,posMaintActionField)
    origPosReqRefIDField.foreach(fmt(b,_))
    posMaintRptRefIDField.foreach(fmt(b,_))
    fmt(b,clearingBusinessDateField)
    settlSessIDField.foreach(fmt(b,_))
    settlSessSubIDField.foreach(fmt(b,_))
    fmt(b,partiesComponent)
    fmt(b,accountField)
    acctIDSourceField.foreach(fmt(b,_))
    fmt(b,accountTypeField)
    fmt(b,instrumentComponent)
    currencyField.foreach(fmt(b,_))
    noLegsField.foreach(fmt(b,_))
    legsGroups.getOrElse(List.empty).foreach(fmt(b,_))
    noUnderlyingsField.foreach(fmt(b,_))
    underlyingsGroups.getOrElse(List.empty).foreach(fmt(b,_))
    noTradingSessionsField.foreach(fmt(b,_))
    tradingSessionsGroups.getOrElse(List.empty).foreach(fmt(b,_))
    fmt(b,transactTimeField)
    fmt(b,positionQtyComponent)
    adjustmentTypeField.foreach(fmt(b,_))
    contraryInstructionIndicatorField.foreach(fmt(b,_))
    priorSpreadIndicatorField.foreach(fmt(b,_))
    thresholdAmountField.foreach(fmt(b,_))
    textField.foreach(fmt(b,_))
    encodedTextLenField.foreach(fmt(b,_))
    encodedTextField.foreach(fmt(b,_))
    b
  }

}
     
object PositionMaintenanceRequestMessage extends SfFixMessageDecoder {
  val MsgType="AL"
  val MsgName="PositionMaintenanceRequest"
             
  override val MandatoryFields = HashSet[Int](
    PosReqIDField.TagId, PosTransTypeField.TagId, PosMaintActionField.TagId, ClearingBusinessDateField.TagId, AccountField.TagId, 
    AccountTypeField.TagId, TransactTimeField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    PartiesComponent.isMandatoryField(tagId) || InstrumentComponent.isMandatoryField(tagId) || LegsGroup.isMandatoryField(tagId) || UnderlyingsGroup.isMandatoryField(tagId) || 
    TradingSessionsGroup.isMandatoryField(tagId) || PositionQtyComponent.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    OrigPosReqRefIDField.TagId, PosMaintRptRefIDField.TagId, SettlSessIDField.TagId, SettlSessSubIDField.TagId, AcctIDSourceField.TagId, 
    CurrencyField.TagId, NoLegsField.TagId, NoUnderlyingsField.TagId, NoTradingSessionsField.TagId, AdjustmentTypeField.TagId, 
    ContraryInstructionIndicatorField.TagId, PriorSpreadIndicatorField.TagId, ThresholdAmountField.TagId, TextField.TagId, EncodedTextLenField.TagId, 
    EncodedTextField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    PartiesComponent.isOptionalField(tagId) || InstrumentComponent.isOptionalField(tagId) || LegsGroup.isOptionalField(tagId) || UnderlyingsGroup.isOptionalField(tagId) || 
    TradingSessionsGroup.isOptionalField(tagId) || PositionQtyComponent.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    PartiesComponent.isFieldOf(tagId) || InstrumentComponent.isFieldOf(tagId) || LegsGroup.isFieldOf(tagId) || 
    UnderlyingsGroup.isFieldOf(tagId) || TradingSessionsGroup.isFieldOf(tagId) || PositionQtyComponent.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoLegsField.TagId, NoUnderlyingsField.TagId, NoTradingSessionsField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==PosReqIDField.TagId 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(PositionMaintenanceRequestMessage(PosReqIDField.decode(myFields.get(PosReqIDField.TagId)).get,
        PosTransTypeField.decode(myFields.get(PosTransTypeField.TagId)).get,
        PosMaintActionField.decode(myFields.get(PosMaintActionField.TagId)).get,
        myFields.get(OrigPosReqRefIDField.TagId).flatMap(f=>OrigPosReqRefIDField.decode(f)),
        myFields.get(PosMaintRptRefIDField.TagId).flatMap(f=>PosMaintRptRefIDField.decode(f)),
        ClearingBusinessDateField.decode(myFields.get(ClearingBusinessDateField.TagId)).get,
        myFields.get(SettlSessIDField.TagId).flatMap(f=>SettlSessIDField.decode(f)),
        myFields.get(SettlSessSubIDField.TagId).flatMap(f=>SettlSessSubIDField.decode(f)),
        PartiesComponent.decode(flds, startPos).get,
        AccountField.decode(myFields.get(AccountField.TagId)).get,
        myFields.get(AcctIDSourceField.TagId).flatMap(f=>AcctIDSourceField.decode(f)),
        AccountTypeField.decode(myFields.get(AccountTypeField.TagId)).get,
        InstrumentComponent.decode(flds, startPos).get,
        myFields.get(CurrencyField.TagId).flatMap(f=>CurrencyField.decode(f)),
        myFields.get(NoLegsField.TagId).flatMap(f=>NoLegsField.decode(f)),
        if (nextTagPosLookup.contains(NoLegsField.TagId)) LegsGroup.decode(flds, nextTagPosLookup(NoLegsField.TagId)) else None,
        myFields.get(NoUnderlyingsField.TagId).flatMap(f=>NoUnderlyingsField.decode(f)),
        if (nextTagPosLookup.contains(NoUnderlyingsField.TagId)) UnderlyingsGroup.decode(flds, nextTagPosLookup(NoUnderlyingsField.TagId)) else None,
        myFields.get(NoTradingSessionsField.TagId).flatMap(f=>NoTradingSessionsField.decode(f)),
        if (nextTagPosLookup.contains(NoTradingSessionsField.TagId)) TradingSessionsGroup.decode(flds, nextTagPosLookup(NoTradingSessionsField.TagId)) else None,
        TransactTimeField.decode(myFields.get(TransactTimeField.TagId)).get,
        PositionQtyComponent.decode(flds, startPos).get,
        myFields.get(AdjustmentTypeField.TagId).flatMap(f=>AdjustmentTypeField.decode(f)),
        myFields.get(ContraryInstructionIndicatorField.TagId).flatMap(f=>ContraryInstructionIndicatorField.decode(f)),
        myFields.get(PriorSpreadIndicatorField.TagId).flatMap(f=>PriorSpreadIndicatorField.decode(f)),
        myFields.get(ThresholdAmountField.TagId).flatMap(f=>ThresholdAmountField.decode(f)),
        myFields.get(TextField.TagId).flatMap(f=>TextField.decode(f)),
        myFields.get(EncodedTextLenField.TagId).flatMap(f=>EncodedTextLenField.decode(f)),
        myFields.get(EncodedTextField.TagId).flatMap(f=>EncodedTextField.decode(f))))
    } else None
  }

    
}
     