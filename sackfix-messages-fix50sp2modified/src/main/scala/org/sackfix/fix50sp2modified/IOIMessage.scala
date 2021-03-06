package org.sackfix.fix50sp2modified

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixMessageBody, SfFixMessageDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180902
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP2.modified.xml
  */
case class IOIMessage(applicationSequenceControlComponent:Option[ApplicationSequenceControlComponent]=None,
                      iOIIDField:IOIIDField,
                      iOITransTypeField:IOITransTypeField,
                      iOIRefIDField:Option[IOIRefIDField]=None,
                      instrumentComponent:InstrumentComponent,
                      partiesComponent:Option[PartiesComponent]=None,
                      financingDetailsComponent:Option[FinancingDetailsComponent]=None,
                      undInstrmtGrpComponent:Option[UndInstrmtGrpComponent]=None,
                      sideField:SideField,
                      qtyTypeField:Option[QtyTypeField]=None,
                      orderQtyDataComponent:Option[OrderQtyDataComponent]=None,
                      iOIQtyField:IOIQtyField,
                      currencyField:Option[CurrencyField]=None,
                      stipulationsComponent:Option[StipulationsComponent]=None,
                      instrmtLegIOIGrpComponent:Option[InstrmtLegIOIGrpComponent]=None,
                      priceTypeField:Option[PriceTypeField]=None,
                      priceField:Option[PriceField]=None,
                      validUntilTimeField:Option[ValidUntilTimeField]=None,
                      iOIQltyIndField:Option[IOIQltyIndField]=None,
                      iOINaturalFlagField:Option[IOINaturalFlagField]=None,
                      iOIQualGrpComponent:Option[IOIQualGrpComponent]=None,
                      textField:Option[TextField]=None,
                      encodedTextLenField:Option[EncodedTextLenField]=None,
                      encodedTextField:Option[EncodedTextField]=None,
                      transactTimeField:Option[TransactTimeField]=None,
                      uRLLinkField:Option[URLLinkField]=None,
                      routingGrpComponent:Option[RoutingGrpComponent]=None,
                      spreadOrBenchmarkCurveDataComponent:Option[SpreadOrBenchmarkCurveDataComponent]=None,
                      yieldDataComponent:Option[YieldDataComponent]=None) extends SfFixMessageBody("6")  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    applicationSequenceControlComponent.foreach(fmt(b,_))
    fmt(b,iOIIDField)
    fmt(b,iOITransTypeField)
    iOIRefIDField.foreach(fmt(b,_))
    fmt(b,instrumentComponent)
    partiesComponent.foreach(fmt(b,_))
    financingDetailsComponent.foreach(fmt(b,_))
    undInstrmtGrpComponent.foreach(fmt(b,_))
    fmt(b,sideField)
    qtyTypeField.foreach(fmt(b,_))
    orderQtyDataComponent.foreach(fmt(b,_))
    fmt(b,iOIQtyField)
    currencyField.foreach(fmt(b,_))
    stipulationsComponent.foreach(fmt(b,_))
    instrmtLegIOIGrpComponent.foreach(fmt(b,_))
    priceTypeField.foreach(fmt(b,_))
    priceField.foreach(fmt(b,_))
    validUntilTimeField.foreach(fmt(b,_))
    iOIQltyIndField.foreach(fmt(b,_))
    iOINaturalFlagField.foreach(fmt(b,_))
    iOIQualGrpComponent.foreach(fmt(b,_))
    textField.foreach(fmt(b,_))
    encodedTextLenField.foreach(fmt(b,_))
    encodedTextField.foreach(fmt(b,_))
    transactTimeField.foreach(fmt(b,_))
    uRLLinkField.foreach(fmt(b,_))
    routingGrpComponent.foreach(fmt(b,_))
    spreadOrBenchmarkCurveDataComponent.foreach(fmt(b,_))
    yieldDataComponent.foreach(fmt(b,_))
    b
  }

}
     
object IOIMessage extends SfFixMessageDecoder {
  val MsgType="6"
  val MsgName="IOI"
             
  override val MandatoryFields = HashSet[Int](
    IOIIDField.TagId, IOITransTypeField.TagId, SideField.TagId, IOIQtyField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    ApplicationSequenceControlComponent.isMandatoryField(tagId) || InstrumentComponent.isMandatoryField(tagId) || PartiesComponent.isMandatoryField(tagId) || FinancingDetailsComponent.isMandatoryField(tagId) || 
    UndInstrmtGrpComponent.isMandatoryField(tagId) || OrderQtyDataComponent.isMandatoryField(tagId) || StipulationsComponent.isMandatoryField(tagId) || InstrmtLegIOIGrpComponent.isMandatoryField(tagId) || 
    IOIQualGrpComponent.isMandatoryField(tagId) || RoutingGrpComponent.isMandatoryField(tagId) || SpreadOrBenchmarkCurveDataComponent.isMandatoryField(tagId) || YieldDataComponent.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    IOIRefIDField.TagId, QtyTypeField.TagId, CurrencyField.TagId, PriceTypeField.TagId, PriceField.TagId, 
    ValidUntilTimeField.TagId, IOIQltyIndField.TagId, IOINaturalFlagField.TagId, TextField.TagId, EncodedTextLenField.TagId, 
    EncodedTextField.TagId, TransactTimeField.TagId, URLLinkField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    ApplicationSequenceControlComponent.isOptionalField(tagId) || InstrumentComponent.isOptionalField(tagId) || PartiesComponent.isOptionalField(tagId) || FinancingDetailsComponent.isOptionalField(tagId) || 
    UndInstrmtGrpComponent.isOptionalField(tagId) || OrderQtyDataComponent.isOptionalField(tagId) || StipulationsComponent.isOptionalField(tagId) || InstrmtLegIOIGrpComponent.isOptionalField(tagId) || 
    IOIQualGrpComponent.isOptionalField(tagId) || RoutingGrpComponent.isOptionalField(tagId) || SpreadOrBenchmarkCurveDataComponent.isOptionalField(tagId) || YieldDataComponent.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    ApplicationSequenceControlComponent.isFieldOf(tagId) || InstrumentComponent.isFieldOf(tagId) || PartiesComponent.isFieldOf(tagId) || 
    FinancingDetailsComponent.isFieldOf(tagId) || UndInstrmtGrpComponent.isFieldOf(tagId) || OrderQtyDataComponent.isFieldOf(tagId) || 
    StipulationsComponent.isFieldOf(tagId) || InstrmtLegIOIGrpComponent.isFieldOf(tagId) || IOIQualGrpComponent.isFieldOf(tagId) || 
    RoutingGrpComponent.isFieldOf(tagId) || SpreadOrBenchmarkCurveDataComponent.isFieldOf(tagId) || YieldDataComponent.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = ApplicationSequenceControlComponent.isFirstField(tagId) 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(IOIMessage(ApplicationSequenceControlComponent.decode(flds, startPos),
        IOIIDField.decode(myFields.get(IOIIDField.TagId)).get,
        IOITransTypeField.decode(myFields.get(IOITransTypeField.TagId)).get,
        myFields.get(IOIRefIDField.TagId).flatMap(f=>IOIRefIDField.decode(f)),
        InstrumentComponent.decode(flds, startPos).get,
        PartiesComponent.decode(flds, startPos),
        FinancingDetailsComponent.decode(flds, startPos),
        UndInstrmtGrpComponent.decode(flds, startPos),
        SideField.decode(myFields.get(SideField.TagId)).get,
        myFields.get(QtyTypeField.TagId).flatMap(f=>QtyTypeField.decode(f)),
        OrderQtyDataComponent.decode(flds, startPos),
        IOIQtyField.decode(myFields.get(IOIQtyField.TagId)).get,
        myFields.get(CurrencyField.TagId).flatMap(f=>CurrencyField.decode(f)),
        StipulationsComponent.decode(flds, startPos),
        InstrmtLegIOIGrpComponent.decode(flds, startPos),
        myFields.get(PriceTypeField.TagId).flatMap(f=>PriceTypeField.decode(f)),
        myFields.get(PriceField.TagId).flatMap(f=>PriceField.decode(f)),
        myFields.get(ValidUntilTimeField.TagId).flatMap(f=>ValidUntilTimeField.decode(f)),
        myFields.get(IOIQltyIndField.TagId).flatMap(f=>IOIQltyIndField.decode(f)),
        myFields.get(IOINaturalFlagField.TagId).flatMap(f=>IOINaturalFlagField.decode(f)),
        IOIQualGrpComponent.decode(flds, startPos),
        myFields.get(TextField.TagId).flatMap(f=>TextField.decode(f)),
        myFields.get(EncodedTextLenField.TagId).flatMap(f=>EncodedTextLenField.decode(f)),
        myFields.get(EncodedTextField.TagId).flatMap(f=>EncodedTextField.decode(f)),
        myFields.get(TransactTimeField.TagId).flatMap(f=>TransactTimeField.decode(f)),
        myFields.get(URLLinkField.TagId).flatMap(f=>URLLinkField.decode(f)),
        RoutingGrpComponent.decode(flds, startPos),
        SpreadOrBenchmarkCurveDataComponent.decode(flds, startPos),
        YieldDataComponent.decode(flds, startPos)))
    } else None
  }

    
}
     