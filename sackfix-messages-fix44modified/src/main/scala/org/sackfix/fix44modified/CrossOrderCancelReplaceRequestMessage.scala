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
case class CrossOrderCancelReplaceRequestMessage(orderIDField:Option[OrderIDField]=None,
                                                 crossIDField:CrossIDField,
                                                 origCrossIDField:OrigCrossIDField,
                                                 crossTypeField:CrossTypeField,
                                                 crossPrioritizationField:CrossPrioritizationField,
                                                 noSidesField:NoSidesField,
                                                 sidesGroups: List[SidesGroup],
                                                 instrumentComponent:InstrumentComponent,
                                                 noUnderlyingsField:Option[NoUnderlyingsField]=None,
                                                 underlyingsGroups: Option[List[UnderlyingsGroup]]=None,
                                                 noLegsField:Option[NoLegsField]=None,
                                                 legsGroups: Option[List[LegsGroup]]=None,
                                                 settlTypeField:Option[SettlTypeField]=None,
                                                 settlDateField:Option[SettlDateField]=None,
                                                 handlInstField:Option[HandlInstField]=None,
                                                 execInstField:Option[ExecInstField]=None,
                                                 minQtyField:Option[MinQtyField]=None,
                                                 maxFloorField:Option[MaxFloorField]=None,
                                                 exDestinationField:Option[ExDestinationField]=None,
                                                 noTradingSessionsField:Option[NoTradingSessionsField]=None,
                                                 tradingSessionsGroups: Option[List[TradingSessionsGroup]]=None,
                                                 processCodeField:Option[ProcessCodeField]=None,
                                                 prevClosePxField:Option[PrevClosePxField]=None,
                                                 locateReqdField:Option[LocateReqdField]=None,
                                                 transactTimeField:TransactTimeField,
                                                 stipulationsComponent:Option[StipulationsComponent]=None,
                                                 ordTypeField:OrdTypeField,
                                                 priceTypeField:Option[PriceTypeField]=None,
                                                 priceField:Option[PriceField]=None,
                                                 stopPxField:Option[StopPxField]=None,
                                                 spreadOrBenchmarkCurveDataComponent:Option[SpreadOrBenchmarkCurveDataComponent]=None,
                                                 yieldDataComponent:Option[YieldDataComponent]=None,
                                                 currencyField:Option[CurrencyField]=None,
                                                 complianceIDField:Option[ComplianceIDField]=None,
                                                 iOIIDField:Option[IOIIDField]=None,
                                                 quoteIDField:Option[QuoteIDField]=None,
                                                 timeInForceField:Option[TimeInForceField]=None,
                                                 effectiveTimeField:Option[EffectiveTimeField]=None,
                                                 expireDateField:Option[ExpireDateField]=None,
                                                 expireTimeField:Option[ExpireTimeField]=None,
                                                 gTBookingInstField:Option[GTBookingInstField]=None,
                                                 maxShowField:Option[MaxShowField]=None,
                                                 pegInstructionsComponent:Option[PegInstructionsComponent]=None,
                                                 discretionInstructionsComponent:Option[DiscretionInstructionsComponent]=None,
                                                 targetStrategyField:Option[TargetStrategyField]=None,
                                                 targetStrategyParametersField:Option[TargetStrategyParametersField]=None,
                                                 participationRateField:Option[ParticipationRateField]=None,
                                                 cancellationRightsField:Option[CancellationRightsField]=None,
                                                 moneyLaunderingStatusField:Option[MoneyLaunderingStatusField]=None,
                                                 registIDField:Option[RegistIDField]=None,
                                                 designationField:Option[DesignationField]=None) extends SfFixMessageBody("t")  with SfFixRenderable with SfFixFieldsToAscii {
  if (noSidesField.value != sidesGroups.size)
    throw SfRepeatingGroupCountException(NoSidesField.TagId,noSidesField.value, sidesGroups.size)
  if (noUnderlyingsField.map(_.value).getOrElse(0) != underlyingsGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoUnderlyingsField.TagId,noUnderlyingsField.map(_.value).getOrElse(0), underlyingsGroups.map(_.size).getOrElse(0))
  if (noLegsField.map(_.value).getOrElse(0) != legsGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoLegsField.TagId,noLegsField.map(_.value).getOrElse(0), legsGroups.map(_.size).getOrElse(0))
  if (noTradingSessionsField.map(_.value).getOrElse(0) != tradingSessionsGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoTradingSessionsField.TagId,noTradingSessionsField.map(_.value).getOrElse(0), tradingSessionsGroups.map(_.size).getOrElse(0))

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    orderIDField.foreach(fmt(b,_))
    fmt(b,crossIDField)
    fmt(b,origCrossIDField)
    fmt(b,crossTypeField)
    fmt(b,crossPrioritizationField)
    fmt(b,noSidesField)
    fmt(b,instrumentComponent)
    noUnderlyingsField.foreach(fmt(b,_))
    underlyingsGroups.getOrElse(List.empty).foreach(fmt(b,_))
    noLegsField.foreach(fmt(b,_))
    legsGroups.getOrElse(List.empty).foreach(fmt(b,_))
    settlTypeField.foreach(fmt(b,_))
    settlDateField.foreach(fmt(b,_))
    handlInstField.foreach(fmt(b,_))
    execInstField.foreach(fmt(b,_))
    minQtyField.foreach(fmt(b,_))
    maxFloorField.foreach(fmt(b,_))
    exDestinationField.foreach(fmt(b,_))
    noTradingSessionsField.foreach(fmt(b,_))
    tradingSessionsGroups.getOrElse(List.empty).foreach(fmt(b,_))
    processCodeField.foreach(fmt(b,_))
    prevClosePxField.foreach(fmt(b,_))
    locateReqdField.foreach(fmt(b,_))
    fmt(b,transactTimeField)
    stipulationsComponent.foreach(fmt(b,_))
    fmt(b,ordTypeField)
    priceTypeField.foreach(fmt(b,_))
    priceField.foreach(fmt(b,_))
    stopPxField.foreach(fmt(b,_))
    spreadOrBenchmarkCurveDataComponent.foreach(fmt(b,_))
    yieldDataComponent.foreach(fmt(b,_))
    currencyField.foreach(fmt(b,_))
    complianceIDField.foreach(fmt(b,_))
    iOIIDField.foreach(fmt(b,_))
    quoteIDField.foreach(fmt(b,_))
    timeInForceField.foreach(fmt(b,_))
    effectiveTimeField.foreach(fmt(b,_))
    expireDateField.foreach(fmt(b,_))
    expireTimeField.foreach(fmt(b,_))
    gTBookingInstField.foreach(fmt(b,_))
    maxShowField.foreach(fmt(b,_))
    pegInstructionsComponent.foreach(fmt(b,_))
    discretionInstructionsComponent.foreach(fmt(b,_))
    targetStrategyField.foreach(fmt(b,_))
    targetStrategyParametersField.foreach(fmt(b,_))
    participationRateField.foreach(fmt(b,_))
    cancellationRightsField.foreach(fmt(b,_))
    moneyLaunderingStatusField.foreach(fmt(b,_))
    registIDField.foreach(fmt(b,_))
    designationField.foreach(fmt(b,_))
    b
  }

}
     
object CrossOrderCancelReplaceRequestMessage extends SfFixMessageDecoder {
  val MsgType="t"
  val MsgName="CrossOrderCancelReplaceRequest"
             
  override val MandatoryFields = HashSet[Int](
    CrossIDField.TagId, OrigCrossIDField.TagId, CrossTypeField.TagId, CrossPrioritizationField.TagId, NoSidesField.TagId, 
    TransactTimeField.TagId, OrdTypeField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    SidesGroup.isMandatoryField(tagId) || InstrumentComponent.isMandatoryField(tagId) || UnderlyingsGroup.isMandatoryField(tagId) || LegsGroup.isMandatoryField(tagId) || 
    TradingSessionsGroup.isMandatoryField(tagId) || StipulationsComponent.isMandatoryField(tagId) || SpreadOrBenchmarkCurveDataComponent.isMandatoryField(tagId) || YieldDataComponent.isMandatoryField(tagId) || 
    PegInstructionsComponent.isMandatoryField(tagId) || DiscretionInstructionsComponent.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    OrderIDField.TagId, NoUnderlyingsField.TagId, NoLegsField.TagId, SettlTypeField.TagId, SettlDateField.TagId, 
    HandlInstField.TagId, ExecInstField.TagId, MinQtyField.TagId, MaxFloorField.TagId, ExDestinationField.TagId, 
    NoTradingSessionsField.TagId, ProcessCodeField.TagId, PrevClosePxField.TagId, LocateReqdField.TagId, PriceTypeField.TagId, 
    PriceField.TagId, StopPxField.TagId, CurrencyField.TagId, ComplianceIDField.TagId, IOIIDField.TagId, 
    QuoteIDField.TagId, TimeInForceField.TagId, EffectiveTimeField.TagId, ExpireDateField.TagId, ExpireTimeField.TagId, 
    GTBookingInstField.TagId, MaxShowField.TagId, TargetStrategyField.TagId, TargetStrategyParametersField.TagId, ParticipationRateField.TagId, 
    CancellationRightsField.TagId, MoneyLaunderingStatusField.TagId, RegistIDField.TagId, DesignationField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    SidesGroup.isOptionalField(tagId) || InstrumentComponent.isOptionalField(tagId) || UnderlyingsGroup.isOptionalField(tagId) || LegsGroup.isOptionalField(tagId) || 
    TradingSessionsGroup.isOptionalField(tagId) || StipulationsComponent.isOptionalField(tagId) || SpreadOrBenchmarkCurveDataComponent.isOptionalField(tagId) || YieldDataComponent.isOptionalField(tagId) || 
    PegInstructionsComponent.isOptionalField(tagId) || DiscretionInstructionsComponent.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    SidesGroup.isFieldOf(tagId) || InstrumentComponent.isFieldOf(tagId) || UnderlyingsGroup.isFieldOf(tagId) || 
    LegsGroup.isFieldOf(tagId) || TradingSessionsGroup.isFieldOf(tagId) || StipulationsComponent.isFieldOf(tagId) || 
    SpreadOrBenchmarkCurveDataComponent.isFieldOf(tagId) || YieldDataComponent.isFieldOf(tagId) || PegInstructionsComponent.isFieldOf(tagId) || 
    DiscretionInstructionsComponent.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoSidesField.TagId, NoUnderlyingsField.TagId, NoLegsField.TagId, NoTradingSessionsField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==OrderIDField.TagId 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(CrossOrderCancelReplaceRequestMessage(myFields.get(OrderIDField.TagId).flatMap(f=>OrderIDField.decode(f)),
        CrossIDField.decode(myFields.get(CrossIDField.TagId)).get,
        OrigCrossIDField.decode(myFields.get(OrigCrossIDField.TagId)).get,
        CrossTypeField.decode(myFields.get(CrossTypeField.TagId)).get,
        CrossPrioritizationField.decode(myFields.get(CrossPrioritizationField.TagId)).get,
        NoSidesField.decode(myFields.get(NoSidesField.TagId)).get,
        if (nextTagPosLookup.contains(NoSidesField.TagId)) SidesGroup.decode(flds, nextTagPosLookup(NoSidesField.TagId)).get else List.empty,
        InstrumentComponent.decode(flds, startPos).get,
        myFields.get(NoUnderlyingsField.TagId).flatMap(f=>NoUnderlyingsField.decode(f)),
        if (nextTagPosLookup.contains(NoUnderlyingsField.TagId)) UnderlyingsGroup.decode(flds, nextTagPosLookup(NoUnderlyingsField.TagId)) else None,
        myFields.get(NoLegsField.TagId).flatMap(f=>NoLegsField.decode(f)),
        if (nextTagPosLookup.contains(NoLegsField.TagId)) LegsGroup.decode(flds, nextTagPosLookup(NoLegsField.TagId)) else None,
        myFields.get(SettlTypeField.TagId).flatMap(f=>SettlTypeField.decode(f)),
        myFields.get(SettlDateField.TagId).flatMap(f=>SettlDateField.decode(f)),
        myFields.get(HandlInstField.TagId).flatMap(f=>HandlInstField.decode(f)),
        myFields.get(ExecInstField.TagId).flatMap(f=>ExecInstField.decode(f)),
        myFields.get(MinQtyField.TagId).flatMap(f=>MinQtyField.decode(f)),
        myFields.get(MaxFloorField.TagId).flatMap(f=>MaxFloorField.decode(f)),
        myFields.get(ExDestinationField.TagId).flatMap(f=>ExDestinationField.decode(f)),
        myFields.get(NoTradingSessionsField.TagId).flatMap(f=>NoTradingSessionsField.decode(f)),
        if (nextTagPosLookup.contains(NoTradingSessionsField.TagId)) TradingSessionsGroup.decode(flds, nextTagPosLookup(NoTradingSessionsField.TagId)) else None,
        myFields.get(ProcessCodeField.TagId).flatMap(f=>ProcessCodeField.decode(f)),
        myFields.get(PrevClosePxField.TagId).flatMap(f=>PrevClosePxField.decode(f)),
        myFields.get(LocateReqdField.TagId).flatMap(f=>LocateReqdField.decode(f)),
        TransactTimeField.decode(myFields.get(TransactTimeField.TagId)).get,
        StipulationsComponent.decode(flds, startPos),
        OrdTypeField.decode(myFields.get(OrdTypeField.TagId)).get,
        myFields.get(PriceTypeField.TagId).flatMap(f=>PriceTypeField.decode(f)),
        myFields.get(PriceField.TagId).flatMap(f=>PriceField.decode(f)),
        myFields.get(StopPxField.TagId).flatMap(f=>StopPxField.decode(f)),
        SpreadOrBenchmarkCurveDataComponent.decode(flds, startPos),
        YieldDataComponent.decode(flds, startPos),
        myFields.get(CurrencyField.TagId).flatMap(f=>CurrencyField.decode(f)),
        myFields.get(ComplianceIDField.TagId).flatMap(f=>ComplianceIDField.decode(f)),
        myFields.get(IOIIDField.TagId).flatMap(f=>IOIIDField.decode(f)),
        myFields.get(QuoteIDField.TagId).flatMap(f=>QuoteIDField.decode(f)),
        myFields.get(TimeInForceField.TagId).flatMap(f=>TimeInForceField.decode(f)),
        myFields.get(EffectiveTimeField.TagId).flatMap(f=>EffectiveTimeField.decode(f)),
        myFields.get(ExpireDateField.TagId).flatMap(f=>ExpireDateField.decode(f)),
        myFields.get(ExpireTimeField.TagId).flatMap(f=>ExpireTimeField.decode(f)),
        myFields.get(GTBookingInstField.TagId).flatMap(f=>GTBookingInstField.decode(f)),
        myFields.get(MaxShowField.TagId).flatMap(f=>MaxShowField.decode(f)),
        PegInstructionsComponent.decode(flds, startPos),
        DiscretionInstructionsComponent.decode(flds, startPos),
        myFields.get(TargetStrategyField.TagId).flatMap(f=>TargetStrategyField.decode(f)),
        myFields.get(TargetStrategyParametersField.TagId).flatMap(f=>TargetStrategyParametersField.decode(f)),
        myFields.get(ParticipationRateField.TagId).flatMap(f=>ParticipationRateField.decode(f)),
        myFields.get(CancellationRightsField.TagId).flatMap(f=>CancellationRightsField.decode(f)),
        myFields.get(MoneyLaunderingStatusField.TagId).flatMap(f=>MoneyLaunderingStatusField.decode(f)),
        myFields.get(RegistIDField.TagId).flatMap(f=>RegistIDField.decode(f)),
        myFields.get(DesignationField.TagId).flatMap(f=>DesignationField.decode(f))))
    } else None
  }

    
}
     